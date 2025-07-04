package com.appsdeveloperblog.estore.transfers.ui;

import org.springframework.web.bind.annotation.RestController;

import com.appsdeveloperblog.estore.transfers.model.TransferRestModel;
import com.appsdeveloperblog.estore.transfers.service.TransferService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/transfers")
public class TransfersController {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
    private TransferService transferService;

    public TransfersController(TransferService transferService) {
        this.transferService = transferService;
    }

    @PostMapping()
    public boolean transfer(@RequestBody TransferRestModel transferRestModel) {
        return transferService.transfer(transferRestModel);
    }
}
