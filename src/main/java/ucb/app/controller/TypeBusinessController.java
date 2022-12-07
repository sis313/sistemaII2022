package ucb.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ucb.app.dto.TypeBusinessDto;
import ucb.app.service.TypeBusinessService;

@RestController
@RequestMapping("api/typeBusiness")
public class TypeBusinessController {
    private TypeBusinessService typeBusinessService;

    @Autowired
    public TypeBusinessController(TypeBusinessService typeBusinessService) {
        this.typeBusinessService = typeBusinessService;
    }

    @GetMapping
    public ResponseEntity<List<TypeBusinessDto>> getTypeBusinesses() {
        List<TypeBusinessDto> typeBusinesses = typeBusinessService.findAllDto();
        return new ResponseEntity<>(typeBusinesses, HttpStatus.OK);
    }

    @GetMapping(path = "/{typeBusinessId}")
    public ResponseEntity<TypeBusinessDto> getTypeBusinessById(@PathVariable("typeBusinessId") Integer typeBusinessId)
            throws Exception {
        TypeBusinessDto typeBusiness = typeBusinessService.findByIdDto(typeBusinessId);
        return new ResponseEntity<>(typeBusiness, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TypeBusinessDto> postTypeBusiness(@RequestBody TypeBusinessDto typeBusinessDto) {
        TypeBusinessDto response = typeBusinessService.saveDto(typeBusinessDto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping(path = "/{typeBusinessId}")
    public ResponseEntity<TypeBusinessDto> putTypeBusiness(@PathVariable("typeBusinessId") Integer typeBusinessId,
            @RequestBody TypeBusinessDto typeBusinessDto) {
        TypeBusinessDto response = typeBusinessService.updateDto(typeBusinessId, typeBusinessDto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping(path = "/{typeBusinessId}")
    public ResponseEntity<String> deleteTypeBusiness(@PathVariable("typeBusinessId") Integer typeBusinessId) {
        String response = typeBusinessService.deleteByIdDto(typeBusinessId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
