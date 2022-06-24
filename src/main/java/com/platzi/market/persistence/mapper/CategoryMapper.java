package com.platzi.market.persistence.mapper;

import com.platzi.market.domain.Category;
import com.platzi.market.persistence.entity.Categoria;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring") //es un mapeador que se integra con un componente de tipo spring
public interface CategoryMapper {

    @Mappings({
            @Mapping(source = "idCategoria", target = "categoryId"), //source= fuente, target=a donde quiero llevarlo
            @Mapping(source = "descripcion", target = "category"),
            @Mapping(source = "estado", target = "active")
    })
    Category toCategory(Categoria categoria); //Convertir una Categoria a Category con el método toCategory

    @InheritInverseConfiguration  //permite que se use las lineas de código de Mappings sin volverlo a escribir. Esto quiere decir que hace el mismo proceso pero inverso
    @Mapping(target = "productos", ignore = true) //como la clase Categoria tiene más atributos de los que se muestran en Mapping, se le especifica que el dato de producto no llegará
    Categoria toCategoria(Category category); //Conversión externa, de Categoría a Category

}
