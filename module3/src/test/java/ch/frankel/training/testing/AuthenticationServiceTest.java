package ch.frankel.training.testing;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AuthenticationServiceTest {

    private AuthenticationService service;
    private PersonRepository repository;
    private Encoder encoder;

    @BeforeMethod
    protected void setUp() {
        repository = mock(PersonRepository.class);
        encoder = mock(Encoder.class);
        service = new AuthenticationService(repository, encoder);
    }

    @Test(expectedExceptions = AuthenticationException.class)
    public void should_throw_exception_if_person_does_not_exist() {
        when(repository.find(anyString())).thenThrow(new NotFoundException());
        service.checkCredentials("aName", "aPassword");
    }

    @Test(expectedExceptions = AuthenticationException.class)
    public void should_throw_exception_if_password_hashes_dont_match() {
        String name = "aName";
        String wrongPassword = "bar";
        Person fake = new Person(name, "foo");
        when(repository.find(name)).thenReturn(fake);
        when(encoder.encode(wrongPassword)).thenReturn("wrongHash");
        service.checkCredentials(name, wrongPassword);
    }

    @Test
    public void should_return_person_if_password_hashes_match() {
        String name = "aName";
        String password = "foo";
        String hash = "bar";
        Person fake = new Person(name, hash);
        when(repository.find(name)).thenReturn(fake);
        when(encoder.encode(password)).thenReturn(hash);
        Person person = service.checkCredentials(name, password);
        assertThat(person.getName()).isSameAs(name);
    }
}
