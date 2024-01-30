package BankProject.controllerTest;

import BankProject.controller.AccountController;
import BankProject.repository.AccountRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;

@ExtendWith(MockitoExtension.class)
public class AccountInterfaceControllerTest {

    private MockMvc mockMvc;

    @Mock
    private AccountRepository accountRepository;

    @InjectMocks
    private AccountController accountController;
}
