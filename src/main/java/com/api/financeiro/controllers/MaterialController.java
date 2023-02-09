package com.api.financeiro.controllers;

import com.api.financeiro.dtos.DespesasDto;
import com.api.financeiro.dtos.MaterialDto;
import com.api.financeiro.dtos.ResponseGeneralDto;
import com.api.financeiro.entities.DespesasEntity;
import com.api.financeiro.entities.MaterialEntity;
import com.api.financeiro.services.MaterialService;
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
import java.time.ZoneId;
import java.util.Optional;
import java.util.UUID;

import static com.api.financeiro.enums.GeneralMessages.*;

@RestController
@CrossOrigin(value = "*", maxAge = 3600)
@RequestMapping("/financeiro/despesa/material")
public class MaterialController {

    @Autowired
    MaterialService materialService;

    private static MaterialEntity setMaterialEntity(MaterialDto materialDto) {
        var materialEntity = new MaterialEntity();
        BeanUtils.copyProperties(materialDto, materialEntity);
        return materialEntity;
    }
    private static ResponseGeneralDto responseGeneralDto(HttpStatus status, String message) {
        ResponseGeneralDto response = new ResponseGeneralDto();
        response.setMessage(message);
        response.setStatus(status);
        return response;
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Object> novoMaterial(@RequestBody @Valid MaterialDto materialDto) {
        return ResponseEntity.status(HttpStatus.OK).body(this.materialService.cadastrarNovoMaterial(setMaterialEntity(materialDto)));
    }

    @GetMapping("/buscar")
    public ResponseEntity<Page<MaterialEntity>> buscarTodosOsMateriais(@PageableDefault(page = 0, size = 10,
            sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(materialService.findAll(pageable));
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Object> getOneMaterial(@PathVariable(value = "id")UUID id){
        Optional<MaterialEntity> materialEntityOptional = materialService.finById(id);
        if (!materialEntityOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseGeneralDto(HttpStatus.NOT_FOUND, MATERIAL_NAO_ENCONTRADO));
        }
        return ResponseEntity.status(HttpStatus.OK).body(materialEntityOptional.get());
    }
    @DeleteMapping("/remover-material/{id}")
    public ResponseEntity<Object> removerMaterial(@PathVariable(value = "id") UUID id) {
        Optional<MaterialEntity> entity = this.materialService.finById(id);
        if (entity.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseGeneralDto(HttpStatus.NOT_FOUND, MATERIAL_NAO_ENCONTRADO));
        }
        this.materialService.remove(entity.get());
        return ResponseEntity.status(HttpStatus.OK).body(responseGeneralDto(HttpStatus.OK, MATERIAL_REMOVIDO));
    }

    @PutMapping("/atualizar-material/{id}")
    public ResponseEntity<Object> updateMaterial(@PathVariable(value = "id") UUID id,
                                                        @RequestBody @Valid MaterialDto materialDto) {
        Optional<MaterialEntity> materialEntityOptional = materialService.finById(id);
        if (!materialEntityOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseGeneralDto(HttpStatus.NOT_FOUND, MATERIAL_NAO_ENCONTRADO));
        }
        var materialEntity = new MaterialEntity();
        BeanUtils.copyProperties(materialDto, materialEntity);
        materialEntity.setId(materialEntityOptional.get().getId());
        return ResponseEntity.status(HttpStatus.OK).body(materialService.save(materialEntity));
    }

}
