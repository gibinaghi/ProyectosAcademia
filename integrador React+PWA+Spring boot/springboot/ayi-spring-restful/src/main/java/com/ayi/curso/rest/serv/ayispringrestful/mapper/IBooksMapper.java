package com.ayi.curso.rest.serv.ayispringrestful.mapper;

import com.ayi.curso.rest.serv.ayispringrestful.dto.response.BookDTOResponse;
import com.ayi.curso.rest.serv.ayispringrestful.entity.Books;

public interface IBooksMapper {
    Books convertDtoToEntityAll(BookDTOResponse request);

    BookDTOResponse convertEntityToDtoAll(Books entity);
}
