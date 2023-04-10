package co.shop.controller.impl;

import co.shop.controller.PersonController;
import co.shop.model.dto.PersonDTO;
import co.shop.model.mapper.PersonMapper;
import co.shop.service.PersonService;
import co.shop.model.entity.user.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RequestMapping("/api/person")
@CrossOrigin(origins =  {"http://192.168.1.2:4200","http://localhost:4200","192.168.1.2:8080","http://192.168.137.147"})
@RestController
public class PersonControllerImpl implements PersonController {
    private final PersonService personService;
    private final PersonMapper personMapper;

    public PersonControllerImpl(PersonService personService, PersonMapper personMapper) {
        this.personService = personService;
        this.personMapper = personMapper;
    }

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PersonDTO save(@RequestBody PersonDTO personDTO) {
        personDTO.setUuid(UUID.randomUUID().toString());
        personDTO.setCreateDate(Instant.now());
        personDTO.setEnabled(true);
        Person person = personMapper.asEntity(personDTO);
        return personMapper.asDTO(personService.save(person));
    }

    @Override
    @GetMapping("/{id}")
    public PersonDTO findById(@PathVariable("id") Long id) {
        Person person = personService.findById(id).orElse(null);
        return personMapper.asDTO(person);
    }

    @Override
    @RequestMapping(path = "/",method = RequestMethod.GET)
    public PersonDTO findByUserName(@RequestParam(value = "username") String userName) {
        Person person = personService.findByUserName(userName).orElse(null);
        return personMapper.asDTO(person);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        personService.deleteById(id);
    }

    @Override
    @GetMapping
    public List<PersonDTO> list() {
        return personMapper.asDTOList(personService.findAll());
    }

    @Override
    @GetMapping("/page-query")
    public Page<PersonDTO> pageQuery(Pageable pageable) {
        Page<Person> personPage = personService.findAll(pageable);
        List<PersonDTO> dtoList = personPage
                .stream()
                .map(personMapper::asDTO).collect(Collectors.toList());
        return new PageImpl<>(dtoList, pageable, personPage.getTotalElements());
    }

    @Override
    @PutMapping("/{id}")
    public PersonDTO update(@RequestBody PersonDTO personDTO, @PathVariable("id") Long id) {
        Person person = personMapper.asEntity(personDTO);
        return personMapper.asDTO(personService.update(person, id));
    }
}
