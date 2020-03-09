package com.shell.manage.service;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ManageShell {

    public void runShell();

    public void downloadFile();
}
