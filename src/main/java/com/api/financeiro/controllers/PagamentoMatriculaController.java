package com.api.financeiro.controllers;

import com.api.financeiro.dtos.PagamentoMatriculaDto;
import com.api.financeiro.dtos.ResponseGeneralDto;
import com.api.financeiro.entities.PagamentoMatriculaEntity;
import com.api.financeiro.services.PagamentoMatriculaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import static com.api.financeiro.enums.GeneralMessages.PAGAMENTO_MATRICULA_NÃO_ENCONTRADA;

@RestController
@CrossOrigin(value = "*", maxAge = 3600)
@RequestMapping("/financeiro/pagamento-matricula")
public class PagamentoMatriculaController {
    @Autowired
    PagamentoMatriculaService pagamentoMatriculaService;

    private static PagamentoMatriculaEntity setPagamentoMatriculaEntity(PagamentoMatriculaDto pgto) {
        var pagamentoMatriculaEntity = new PagamentoMatriculaEntity();
        pagamentoMatriculaEntity.setValor(pgto.getValor());
        pagamentoMatriculaEntity.setMatriculaId(pgto.getMatriculaId());
        pagamentoMatriculaEntity.setCursoId(pgto.getCursoId());
        pagamentoMatriculaEntity.setData(LocalDateTime.now());

        return pagamentoMatriculaEntity;
    }

    private static ResponseGeneralDto responseGeneralDto(HttpStatus status, String message) {
        ResponseGeneralDto response = new ResponseGeneralDto();
        response.setMessage(message);
        response.setStatus(status);
        return response;
    }

    @PostMapping
    public ResponseEntity<Object> novoPagamentoMatricula(@RequestBody @Valid PagamentoMatriculaDto pgto) {
        return ResponseEntity.status(HttpStatus.OK).body(this.pagamentoMatriculaService.novoPagamentoMatricula(setPagamentoMatriculaEntity(pgto)));
    }

    @GetMapping
    public ResponseEntity<Page<PagamentoMatriculaEntity>> buscarPagamentos(@PageableDefault(page = 0, size = 10, sort = "data", direction = Sort.Direction.ASC) Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(this.pagamentoMatriculaService.findAll(pageable));
    }

    @GetMapping("/busca")
    public ResponseEntity<Object> findById(
            @RequestParam(name = "id") UUID id,
            @RequestParam(name = "matriculaId", required = false) UUID matriculaId) {
        Optional<PagamentoMatriculaEntity> byId = this.pagamentoMatriculaService.findById(id);

        return byId.<ResponseEntity<Object>>map(pagamentoMatriculaEntity ->
                ResponseEntity.status(HttpStatus.OK).body(pagamentoMatriculaEntity)).orElseGet(() ->
                ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseGeneralDto(HttpStatus.NOT_FOUND, PAGAMENTO_MATRICULA_NÃO_ENCONTRADA)));
    }
}
