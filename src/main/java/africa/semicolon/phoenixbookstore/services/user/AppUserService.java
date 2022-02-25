package africa.semicolon.phoenixbookstore.services.user;

import africa.semicolon.phoenixbookstore.data.dto.AppUserRequestDto;
import africa.semicolon.phoenixbookstore.data.dto.AppUserResponseDto;
import africa.semicolon.phoenixbookstore.exceptions.PhoenixBookStoreException;


public interface AppUserService {

    AppUserResponseDto createUser(AppUserRequestDto userRequestDto) throws PhoenixBookStoreException;
    AppUserResponseDto searchBook(String title);
    AppUserResponseDto addBookToFavourite(AppUserRequestDto book);

}
