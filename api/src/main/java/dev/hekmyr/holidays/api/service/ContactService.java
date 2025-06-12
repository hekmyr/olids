package dev.hekmyr.holidays.api.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.resend.Resend;
import com.resend.core.exception.ResendException;
import com.resend.services.emails.model.*;

import dev.hekmyr.holidays.api.dto.*;

@Service
public class ContactService {

    @Value("${RESEND_API_KEY}")
    private String RESEND_API_KEY;

    @Value("${CONTACT_EMAIL}")
    private String CONTACT_EMAIL;

    @Value("${SUPPORT_DOMAIN_EMAIL}")
    private String SUPPORT_DOMAIN_EMAIL;

    public void send(ContactRequestDTO dto) throws ResendException {
        Resend resend = new Resend(RESEND_API_KEY);

        CreateEmailOptions sendEmailRequest = CreateEmailOptions.builder()
            .from(SUPPORT_DOMAIN_EMAIL)
            .to(CONTACT_EMAIL)
            .subject(dto.getSubject())
            .html("<p>Message from: " + dto.getEmail() + "</p><br>" + dto.getMessage())
            .build();

            resend.emails().send(sendEmailRequest);
    }
}
