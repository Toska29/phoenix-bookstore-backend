package africa.semicolon.phoenixbookstore.services.user;

import africa.semicolon.phoenixbookstore.data.dto.AppUserRequestDto;
import africa.semicolon.phoenixbookstore.data.dto.AppUserResponseDto;
import africa.semicolon.phoenixbookstore.data.models.AppUser;
import africa.semicolon.phoenixbookstore.data.repositories.UserRepository;
import africa.semicolon.phoenixbookstore.exceptions.PhoenixBookStoreException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AppUserServiceImpl implements AppUserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public AppUserResponseDto createUser(AppUserRequestDto userRequestDto) throws PhoenixBookStoreException {
        Optional<AppUser> savedUser = userRepository.findByEmail(userRequestDto.getEmail());
        if (savedUser.isPresent()) {
            throw new PhoenixBookStoreException("User with email already exist");
        }
        AppUser newUser = new AppUser();
        newUser.setEmail(userRequestDto.getEmail());
        newUser.setFirstName(userRequestDto.getFirstName());
        newUser.setLastName(userRequestDto.getLastName());
        userRepository.save(newUser);
        return buildersResponse(newUser);
    }

    private AppUserResponseDto buildersResponse(AppUser newUser) {
        return AppUserResponseDto.builder().firstName(newUser.getFirstName())
                .lastName(newUser.getLastName())
                .email(newUser.getEmail()).build();
    }

    @Override
    public AppUserResponseDto searchBook(String title) {
        return null;
    }

    @Override
    public AppUserResponseDto addBookToFavourite(AppUserRequestDto book) {
        return null;
    }
}
