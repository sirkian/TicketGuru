// package com.example.TicketGuru;

// import static org.assertj.core.api.Assertions.assertThat;

// import org.junit.jupiter.api.Test;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

// import com.example.TicketGuru.domain.Role;
// import com.example.TicketGuru.domain.RoleRepository;

// @DataJpaTest
// public class RoleRepositoryTest {

// @Autowired
// private RoleRepository roleRepository;

// // Testataan roolin luonti
// @Test
// public void createRole() {
// Role role = new Role("Testi-rooli");
// roleRepository.save(role);
// assertThat(role.getRoleId()).isNotNull();
// }

// // Testataan roolin haku CommandLineRunneriin syötetyistä rooleista
// @Test
// public void findRoleByNameShouldReturnRole() {
// Role role = roleRepository.findByRole("Clerk");
// assertThat(role.getRoleId()).isEqualTo(2);
// }
// }
