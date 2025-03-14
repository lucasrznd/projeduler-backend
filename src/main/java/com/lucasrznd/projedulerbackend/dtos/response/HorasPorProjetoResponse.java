package com.lucasrznd.projedulerbackend.dtos.response;

public record HorasPorProjetoResponse(Long projetoId,
                                      String nomeProjeto,
                                      Double totalHoras) {
}
