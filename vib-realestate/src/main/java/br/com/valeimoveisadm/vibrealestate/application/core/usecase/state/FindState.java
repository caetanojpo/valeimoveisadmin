package br.com.valeimoveisadm.vibrealestate.application.core.usecase.state;

import br.com.valeimoveisadm.vibrealestate.application.core.domain.State;
import br.com.valeimoveisadm.vibrealestate.application.ports.repository.StateRepository;

import java.util.List;

public class FindState {
    private final StateRepository repository;

    public FindState(StateRepository repository) {
        this.repository = repository;
    }

    public State executeById(Integer id) {
        return repository.findById(id);
    }

    public List<State> executeAll() {
        return repository.findAll();
    }
}
