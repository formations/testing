package ch.frankel.training.testing;

public class AuthenticationService {

    private final PersonRepository repository;
    private final Encoder encoder;

    public AuthenticationService(PersonRepository repository, Encoder encoder) {
        this.repository = repository;
        this.encoder = encoder;
    }

    public Person checkCredentials(String name, String password) {
        try {
            Person person = repository.find(name);
            String existingHash = person.getHash();
            String hashed = encoder.encode(password);
            checkMatchHashes(existingHash, hashed);
            return person;
        } catch (NotFoundException e) {
            throw new AuthenticationException(e);
        }
    }

    private void checkMatchHashes(String existingHash, String hashed) {
        if (!existingHash.equals(hashed)) {
            throw new AuthenticationException();
        }
    }
}
