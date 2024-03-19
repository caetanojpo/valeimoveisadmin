package br.com.valeimoveisadm.vibrealestate.application.core.usecase.address;

import br.com.valeimoveisadm.vibrealestate.application.core.domain.Address;
import br.com.valeimoveisadm.vibrealestate.application.core.domain.State;
import br.com.valeimoveisadm.vibrealestate.application.core.usecase.state.FindState;
import br.com.valeimoveisadm.vibrealestate.application.ports.repository.AddressRepository;

public class CreateAddress {

    private final AddressRepository repository;
    private final FindState findState;

    public CreateAddress(AddressRepository repository, FindState findState) {
        this.repository = repository;
        this.findState = findState;
    }

    public Address execute(Address address, Integer stateId){
        State state = findState.executeById(stateId);
        address.setState(state);
        return repository.save(address);
    }
}
