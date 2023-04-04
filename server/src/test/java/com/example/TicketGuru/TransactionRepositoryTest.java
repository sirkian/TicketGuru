// package com.example.TicketGuru;

// import static org.assertj.core.api.Assertions.assertThat;

// import java.time.LocalDateTime;

// import org.junit.jupiter.api.Test;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

// import com.example.TicketGuru.domain.AppUser;
// import com.example.TicketGuru.domain.AppUserRepository;
// import com.example.TicketGuru.domain.PostalCode;
// import com.example.TicketGuru.domain.PostalCodeRepository;
// import com.example.TicketGuru.domain.Transaction;
// import com.example.TicketGuru.domain.TransactionRepository;

// @DataJpaTest
// public class TransactionRepositoryTest {

// private static final LocalDateTime LocalDateTime = null;

// @Autowired
// private TransactionRepository trepository;

// @Autowired
// private PostalCodeRepository postrepo;

// @Autowired
// private AppUserRepository appuserrepo;

// //Testataan myyntitapahtuman luonti
// @Test
// public void newTransaction() {

// PostalCode postalcode = new PostalCode("00220", "Helsinki");
// postrepo.save(postalcode);

// AppUser appuser1 = new AppUser("Jäbä", "Dude", "cooljäbä@coolmail.com",
// "hässhäkkhä", "+3589999999", "jäbä on cool", "Jäbäkatu 1", postalcode);
// appuserrepo.save(appuser1);

// Transaction transaction = new Transaction(appuser1, LocalDateTime);
// trepository.save(transaction);
// assertThat(transaction.getTransactionId()).isNotNull();

// }

// //Haetaan kaikki myyntitapahtumat
// @Test
// public void findTransactions() {

// long n1 = trepository.count();

// PostalCode postalcode = new PostalCode("00220", "Helsinki");
// postrepo.save(postalcode);

// AppUser appuser1 = new AppUser("Jäbä", "Dude", "cooljäbä@coolmail.com",
// "hässhäkkhä", "+3589999999", "jäbä on cool", "Jäbäkatu 1", postalcode);
// appuserrepo.save(appuser1);

// Transaction transaction = new Transaction(appuser1, LocalDateTime);
// trepository.save(transaction);

// long n2 = trepository.count();
// assertThat(n2 - n1).isEqualTo(1);

// }
// }
