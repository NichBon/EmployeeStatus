package io.nology.employee.contract;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import io.nology.employee.contract.dtos.CreateContractDTO;
import io.nology.employee.contract.dtos.UpdateContractDTO;
import jakarta.persistence.EntityNotFoundException;

@Service
public class ContractService {

    private ContractRepository contractRepository;
    private ModelMapper modelMapper;

    public ContractService(ContractRepository contractRepository, ModelMapper modelMapper) {
        this.contractRepository = contractRepository;
        this.modelMapper = modelMapper;
    }

    public List<Contract> getAll() {
        List<Contract> contracts = this.contractRepository.findAll();
        return contracts;
    }

    public Contract findById(long id) {
        Contract foundContract = this.contractRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No Contract with id: " + id));
        return foundContract;
    }

    public Contract create(CreateContractDTO data) {
        System.out.println(data);
        Contract newContract = modelMapper.map(data, Contract.class);
        Contract savedContract = this.contractRepository.save(newContract);
        return savedContract;
    }

    public Contract updateById(UpdateContractDTO data) {
        Contract foundContract = findById(data.getId());
        modelMapper.map(data, foundContract);
        this.contractRepository.save(foundContract);
        return foundContract;
    }

    public String deleteById(long id) {
        if (contractRepository.existsById(id)) {
            contractRepository.deleteById(id);
            return ("DELETED ID" + id);
        } else {
            throw new EntityNotFoundException("No Contract with id: " + id);
        }
    }

}
