package com.api.financeiro.controllers;

import com.api.financeiro.dtos.DespesasDto;
import com.api.financeiro.dtos.ResponseGeneralDto;
import com.api.financeiro.entities.DespesasEntity;
import com.api.financeiro.services.DespesasService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
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

import static com.api.financeiro.enums.GeneralMessages.*;

@RestController
@CrossOrigin(value = "*", maxAge = 3600)
@RequestMapping("/financeiro/despesa")
public class DespesasController {

    @Autowired
    private DespesasService despesasService;

    private static ResponseGeneralDto responseGeneralDto(HttpStatus status, String message) {
        ResponseGeneralDto response = new ResponseGeneralDto();
        response.setMessage(message);
        response.setStatus(status);
        return response;
    }

    private static DespesasEntity atualizaDtoDespesas(DespesasDto despesasDto, DespesasEntity despesasEntity) {
        var despEntity = new DespesasEntity();
        BeanUtils.copyProperties(despesasDto, despesasEntity);
        despEntity.setId(despesasEntity.getId());
        despEntity.setData(despesasEntity.getData());
        despEntity.setTipo(despesasEntity.getTipo());
        despEntity.setValor(despesasEntity.getValor());
        return despEntity;
    }

    private DespesasEntity setDespesaEntity(DespesasDto despesasDto) {
        var despesasEntity = new DespesasEntity();
        BeanUtils.copyProperties(despesasDto, despesasEntity);
        despesasEntity.setData(LocalDateTime.now());
        return despesasEntity;
    }

    @PostMapping("/nova")
    public ResponseEntity<Object> novaDespesa(@RequestBody @Valid DespesasDto despesasDto) {
        return ResponseEntity.status(HttpStatus.OK).body(this.despesasService.criarNovaDespesa(setDespesaEntity(despesasDto)));
    }

    @GetMapping("/buscar")
    public ResponseEntity<Page<DespesasEntity>> buscarTodasDespesas(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(despesasService.findAll(pageable));
    }

    @DeleteMapping("/remover/{id}")
    public ResponseEntity<Object> removerDespesa(@PathVariable(value = "id") UUID id) {
        Optional<DespesasEntity> entity = this.despesasService.findById(id);
        if (entity.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseGeneralDto(HttpStatus.NOT_FOUND, DESPESA_NAO_ENCOTRADA));
        }

        this.despesasService.remove(entity.get());
        return ResponseEntity.status(HttpStatus.OK).body(responseGeneralDto(HttpStatus.OK, DESPESA_REMOVIDA));
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Object> atualizarDespesa(@PathVariable(value = "id") UUID id, @RequestBody @Valid DespesasDto despesasDto) {
        Optional<DespesasEntity> entity = this.despesasService.findById(id);
        return entity.map(despesaEntity ->
                ResponseEntity.status(HttpStatus.OK).body(this.despesasService.save(atualizaDtoDespesas(despesasDto, despesaEntity)))).orElseGet(() ->
                ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseGeneralDto(HttpStatus.NOT_FOUND, DESPESA_NAO_ATUALIZADA)));
    }
}
