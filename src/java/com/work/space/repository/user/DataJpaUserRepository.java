package com.work.space.repository.user;

import com.work.space.entity.User;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DataJpaUserRepository implements CrudUserRepository {
    private final UserRepositoryClass userRepository;

    public DataJpaUserRepository(

            UserRepositoryClass userRepository) {

        this.userRepository = userRepository;
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public boolean delete(Long phone) {
        return userRepository.delete(phone) != 0;
    }

    @Override
    public User getByPhone(Long phone) {
        return userRepository.getByPhone(phone).orElse(null);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }
}
