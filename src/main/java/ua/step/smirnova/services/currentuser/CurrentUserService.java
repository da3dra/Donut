package ua.step.smirnova.services.currentuser;

import ua.step.smirnova.dto.CurrentUser;

public interface CurrentUserService {

    boolean canAccessUser(CurrentUser currentUser, Long userId);

}