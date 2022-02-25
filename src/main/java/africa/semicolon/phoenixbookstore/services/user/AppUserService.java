package africa.semicolon.phoenixbookstore.services.user;

import africa.semicolon.phoenixbookstore.data.dto.AppUserRequestDto;
import africa.semicolon.phoenixbookstore.data.dto.AppUserResponseDto;
import africa.semicolon.phoenixbookstore.web.exceptions.BusinessLogicException;

public interface AppUserService {

    AppUserResponseDto createUser(AppUserRequestDto userRequestDto) throws BusinessLogicException;
    AppUserResponseDto searchBook(String title);
    AppUserResponseDto addBookToFavourite(AppUserRequestDto book);

}
