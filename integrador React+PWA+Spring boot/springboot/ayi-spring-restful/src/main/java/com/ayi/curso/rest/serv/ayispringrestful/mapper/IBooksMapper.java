package com.ayi.curso.rest.serv.ayispringrestful.mapper;

import com.ayi.curso.rest.serv.ayispringrestful.dto.request.BookCreateDTORequest;
import com.ayi.curso.rest.serv.ayispringrestful.dto.response.BookDTOResponse;
import com.ayi.curso.rest.serv.ayispringrestful.entity.Books;

public interface IBooksMapper {
    Books convertDtoToEntity(BookDTOResponse request);

    BookDTOResponse convertEntityToDto(Books entity);

    Books convertDtoToEntityCreate(BookCreateDTORequest request);
}
