package com.example.marketing.util;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
//import java.lang.foreign.SymbolLookup;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class CSVRead {



    public static File getFile() throws IOException {

        File file = null;

        try {

            URL url = null;

            // This is the URL object
            url = new URL("https://myevancogent.s3.amazonaws.com/catalog.csv");

            file = new File("catalog.csv");

            //S3 and the final file
            FileUtils.copyURLToFile(url, file);
        } catch (IOException e) {

            e.printStackTrace();
            System.out.println("Unable to load catalog from S3.");

        }


        System.out.println(file.toString());

/*

        Scanner reader = new Scanner(file);

        while(reader.hasNextLine()){

            System.out.println(reader.nextLine());
        }

*/


        return file;
    }

    public static File toJSON(File file){


        try {
            CsvSchema csv = CsvSchema.emptySchema().withHeader();

            CsvMapper csvMapper = new CsvMapper();


            Object data = csvMapper
                    .readerFor(Map.class)
                    .with(csv)
                    .readValues(file)
                    .readAll();


            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

            File jsonfile = new File("output.json");

            objectMapper.writeValue(jsonfile, data);

/*

            //Debugging: Reveal what is being produced.
            System.out.println(jsonfile.toString());

            Scanner reader = new Scanner(jsonfile);

            while(reader.hasNextLine()){

                System.out.println(reader.nextLine());
            }
*/


            return jsonfile;


        }
        catch (Exception e){

            e.printStackTrace();
            System.out.println("Unable to convert csv file to JSON");
        }







        return null;

    }




}
