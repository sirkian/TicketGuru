package com.example.TicketGuru;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import com.example.TicketGuru.domain.AppUser;
import com.example.TicketGuru.domain.AppUserRepository;
import com.example.TicketGuru.domain.AppUser_Role;
import com.example.TicketGuru.domain.AppUser_RoleRepository;
import com.example.TicketGuru.domain.PostalCode;
import com.example.TicketGuru.domain.PostalCodeRepository;
import com.example.TicketGuru.domain.Role;
import com.example.TicketGuru.domain.RoleRepository;

@DataJpaTest
@ActiveProfiles("dev")
public class AppUserRoleRepositoryTest {

    @Autowired
    private AppUser_RoleRepository aurrepository;

    @Autowired
    private RoleRepository rorepository;

    @Autowired
    private AppUserRepository apprepository;

    @Autowired
    private PostalCodeRepository postrepository;

    // Testataan UserRolen luonti
    @Test
    public void newUserRole() {

        PostalCode postalcode = new PostalCode("00220", "Helsinki");
        postrepository.save(postalcode);

        AppUser appuser1 = new AppUser("Jäbä", "Dude", "cooljäbä@coolmail.com",
                "hässhäkkhä", "+3589999999", "jäbä on cool", "Jäbäkatu 1", postalcode);
        apprepository.save(appuser1);

        Role role = new Role("ADMIN");
        rorepository.save(role);

        AppUser_Role userrole = new AppUser_Role(appuser1, role);
        aurrepository.save(userrole);
        assertThat(userrole.getAppUserRoleId()).isNotNull();

    }

    // Haetaan kaikki käyttäjäroolit
    @Test
    public void getAllUserRoles() {
        long n1 = aurrepository.count();

        PostalCode postalcode = new PostalCode("00220", "Helsinki");
        postrepository.save(postalcode);

        AppUser appuser1 = new AppUser("Jäbä", "Dude", "cooljäbä@coolmail.com",
                "hässhäkkhä", "+3589999999", "jäbä on cool", "Jäbäkatu 1", postalcode);
        apprepository.save(appuser1);

        Role role1 = new Role("ADMIN");
        rorepository.save(role1);

        AppUser_Role a1 = new AppUser_Role(appuser1, role1);
        aurrepository.save(a1);

        long n2 = aurrepository.count();
        assertThat(n2 - n1).isEqualTo(1);

    }

}
