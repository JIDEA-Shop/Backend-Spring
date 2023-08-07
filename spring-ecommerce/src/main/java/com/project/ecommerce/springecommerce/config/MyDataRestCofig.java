package com.project.ecommerce.springecommerce.config;

import com.project.ecommerce.springecommerce.entity.Product;
import com.project.ecommerce.springecommerce.entity.ProductCategory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.metamodel.EntityType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Configuration
public class MyDataRestCofig implements RepositoryRestConfigurer {
    EntityManager entityManager;
    @Autowired //inject entity manager
    MyDataRestCofig(EntityManager entityManager)
    {
        this.entityManager = entityManager;
    }
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        //HttpMethod.DELETE, HttpMethod.POST,
        HttpMethod[] unsupportedactions = {HttpMethod.PUT};
        config.getExposureConfiguration()
                .forDomainType(Product.class)
                .withItemExposure((metdata, httpMethods) -> httpMethods.disable(unsupportedactions))
                .withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(unsupportedactions));

        config.getExposureConfiguration()
                .forDomainType(ProductCategory.class)
                .withItemExposure((metdata, httpMethods) -> httpMethods.disable(unsupportedactions))
                .withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(unsupportedactions));

        //call method to help expose all available Ids from All Entity
        exposeIds(config);
        /**
         * If you do not want to expose all ids, simply use
         * config.exposeIdsFor({Product.class,Category.class})
         */
    }

    /**
     * method for exposing all entity ids. by default spring data does not expose ids
     *
     * @param configurer
     */
    private void exposeIds(RepositoryRestConfiguration configurer) {
        //get a list of entity classes from entity manager
        Set<EntityType<?>> entityTypeSet = entityManager.getMetamodel().getEntities();
        // create array list of entity Java Type
        List<Class> entityClasses = new ArrayList<>();
        // save the available entity classes from entity manager to the list
        for(EntityType entityType : entityTypeSet)
        {
            entityClasses.add(entityType.getJavaType());
        }
        //expose Ids for this
        configurer.exposeIdsFor(entityClasses.toArray(new Class[0]));
    }
}
