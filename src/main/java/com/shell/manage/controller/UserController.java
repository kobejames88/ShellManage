package com.shell.manage.controller;

import com.shell.manage.service.ManageShell;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private ManageShell manageShell;

    @ApiOperation(value = "Run the shell ", notes = "Run the shell")
    @RequestMapping(value = "/runShell", method = RequestMethod.POST)
    public String RunShell () {
       manageShell.runShell();
        return "Success";
    }

    @ApiOperation(value = "Download file ", notes = "Download file ")
    @RequestMapping(value = "/downloadFile", method = RequestMethod.POST)
    public String DownloadFile () {
       manageShell.downloadFile();
        return "SUCCESS";
    }
}
