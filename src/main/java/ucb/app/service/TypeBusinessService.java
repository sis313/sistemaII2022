package ucb.app.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ucb.app.dto.TypeBusinessDto;
import ucb.app.model.TypeBusiness;
import ucb.app.repository.TypeBusinessRepository;

@Service
public class TypeBusinessService {
    private TypeBusinessRepository typeBusinessRepository;

    @Autowired
    public TypeBusinessService(TypeBusinessRepository typeBusinessRepository) {
        this.typeBusinessRepository = typeBusinessRepository;
    }

    public List<TypeBusinessDto> findAllDto() {
        return typeBusinessRepository.findAll().stream().map(this::typeBusinessToTypeBusinessDto)
                .collect(Collectors.toList());
    }

    public TypeBusinessDto findByIdDto(Integer typeBusinessId) throws Exception {
        return typeBusinessRepository.findById(typeBusinessId).stream().map(this::typeBusinessToTypeBusinessDto)
                .findFirst()
                .orElseThrow(() -> new Exception("Could not find typeBusiness"));
    }

    public TypeBusinessDto saveDto(TypeBusiness typeBusiness) {
        TypeBusiness response = typeBusinessRepository.save(typeBusiness);
        return typeBusinessToTypeBusinessDto(response);
    }

    public TypeBusinessDto updateDto(Integer typeBusinessId, TypeBusiness typeBusiness) {
        TypeBusiness typeBusinessFound = typeBusinessRepository.getReferenceById(typeBusinessId);
        typeBusinessFound.setName(typeBusiness.getName());
        TypeBusiness response = typeBusinessRepository.save(typeBusinessFound);
        return typeBusinessToTypeBusinessDto(response);
    }

    public String deleteByIdDto(Integer typeBusinessId) {
        typeBusinessRepository.deleteById(typeBusinessId);
        return "TypeBusiness deleted successfully";
    }

    private TypeBusinessDto typeBusinessToTypeBusinessDto(TypeBusiness typeBusiness) {
        TypeBusinessDto typeBusinessDto = new TypeBusinessDto(typeBusiness.getIdTypeBusiness(), typeBusiness.getName());
        return typeBusinessDto;
    }
}
