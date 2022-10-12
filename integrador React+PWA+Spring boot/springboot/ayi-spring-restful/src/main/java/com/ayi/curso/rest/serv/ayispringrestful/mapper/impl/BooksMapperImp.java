package com.ayi.curso.rest.serv.ayispringrestful.mapper.impl;

import com.ayi.curso.rest.serv.ayispringrestful.dto.response.BookDTOResponse;
import com.ayi.curso.rest.serv.ayispringrestful.entity.Books;
import com.ayi.curso.rest.serv.ayispringrestful.mapper.IBooksMapper;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class BooksMapperImp implements IBooksMapper {
    private final ModelMapper modelMapper;

    @Override
    public Books convertDtoToEntityAll(BookDTOResponse request) {

        return modelMapper.map(request, Books.class);
    }

    @Override
    public BookDTOResponse convertEntityToDtoAll(Books entity) {

        return modelMapper.map(entity, BookDTOResponse.class);
    }

}
