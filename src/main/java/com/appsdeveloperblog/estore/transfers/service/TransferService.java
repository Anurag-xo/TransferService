package com.appsdeveloperblog.estore.transfers.service;

import com.appsdeveloperblog.estore.transfers.model.TransferRestModel;

public interface TransferService {
    public boolean transfer(TransferRestModel productPaymentRestModel);
}
