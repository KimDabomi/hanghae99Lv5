package org.sparta.hanghae99lv5.service;

import lombok.RequiredArgsConstructor;
import org.sparta.hanghae99lv5.dto.UserRequestDto;
import org.sparta.hanghae99lv5.entity.Cart;
import org.sparta.hanghae99lv5.entity.User;
import org.sparta.hanghae99lv5.message.ErrorMessage;
import org.sparta.hanghae99lv5.repository.CartRepository;
import org.sparta.hanghae99lv5.repository.UserRepository;
import org.sparta.hanghae99lv5.security.UserAuthEnum;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@RequiredArgsConstructor
public class UserService {

    private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    private static final String PASSWORD_PATTERN = "^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,15}$";
    private final UserRepository userRepository;
    private final CartRepository cartRepository;
    private final PasswordEncoder passwordEncoder;

    public void createUser(UserRequestDto requestDto) {
        String email = requestDto.getEmail();
        String password = requestDto.getPassword();
        String gender = requestDto.getGender();
        String phone = requestDto.getPhone();
        String address = requestDto.getAddress();
        UserAuthEnum auth = UserAuthEnum.valueOf(requestDto.getAuth());

        checkEmailAndPwPattern(email, password);

        String encodedPassword = passwordEncoder.encode(password);
        User user = new User(email, encodedPassword, gender, phone, address, auth);
        userRepository.save(user);

        Cart cart = new Cart(user);
        cartRepository.save(cart);
    }

    private void checkEmailAndPwPattern(String email, String password) {
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        if (!matcher.matches()) {
            throw new IllegalArgumentException(ErrorMessage.EMAIL_FORMAT_ERROR_MESSAGE.getErrorMessage());
        }

        Pattern passwordPattern = Pattern.compile(PASSWORD_PATTERN);
        Matcher passwordMatcher = passwordPattern.matcher(password);
        if (!passwordMatcher.matches()) {
            throw new IllegalArgumentException(ErrorMessage.PASSWORD_VALIDATION_ERROR_MESSAGE.getErrorMessage());
        }
    }
}
