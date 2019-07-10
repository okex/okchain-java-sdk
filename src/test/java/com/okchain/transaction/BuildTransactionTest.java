package com.okchain.transaction;

import com.okchain.client.OKChainClient;
import com.okchain.client.impl.OKChainClientImpl;
import com.okchain.types.AccountInfo;
import com.okchain.types.AddressInfo;
import com.okchain.types.Token;
import com.okchain.types.TransferUnit;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BuildTransactionTest {
    @Test
    public void testBuildNewOrderTx() {
        AccountInfo account = generateAccountInfo();
        String sequence = "50";
        String side = "BUY";
        String product = "xxb_okb";
        String price = "1.00000000";
        String quantity = "1.00000000";
        String memo = "";
        String transaction = BuildTransaction.generatePlaceOrderTransaction(account, side, product, price, quantity, memo);
        System.out.println(transaction);
    }
    @Test
    public void testBuildAminoNewOrderTx() throws IOException {
        AccountInfo account = generateAccountInfo();
        String sequence = "50";
        String side = "BUY";
        String product = "xxb_okb";
        String price = "1.00000000";
        String quantity = "1.00000000";
        String memo = "";
        BuildTransaction.generateAminoPlaceOrderTransaction(account, side, product, price, quantity, memo);

    }

    @Test
    public void testBuildCancelOrderTx() {
        AccountInfo account = generateAccountInfo();

        String sequence = "51";
        String orderId = "ID0000065785-1";
        String memo = "";
        String transaction = BuildTransaction.generateCancelOrderTransaction(account, orderId, memo);
        System.out.println(transaction);
    }
    @Test
    public void testBuildAminoCancelOrderTx() throws IOException {
        AccountInfo account = generateAccountInfo();

        String sequence = "51";
        String orderId = "ID0000065785-1";
        String memo = "";
        BuildTransaction.generateAminoCancelOrderTransaction(account, orderId, memo);

    }

    @Test
    public void testBuildSendTx() {
        AccountInfo account = generateAccountInfo();

        String sequence = "52";
        String to = "okchain1t2cvfv58764q4wdly7qjx5d2z89lewvwq2448n";
        String memo = "";

        List<Token> amountList = new ArrayList<>();
        Token amount = new Token();
        amount.setDenom("okb");
        amount.setAmount("1.00000000");
        amountList.add(amount);

        String transaction = BuildTransaction.generateSendTransaction(account, to, amountList, memo);
        System.out.println(transaction);
    }
    @Test
    public void testBuildAminoSendTx() throws IOException{
        AccountInfo account = generateAccountInfo();

        String sequence = "52";
        String to = "okchain1t2cvfv58764q4wdly7qjx5d2z89lewvwq2448n";
        String memo = "";

        List<Token> amountList = new ArrayList<>();
        Token amount = new Token();
        amount.setDenom("okb");
        amount.setAmount("1.00000000");
        amountList.add(amount);
        BuildTransaction.generateAminoSendTransaction(account,to,amountList,memo);
    }

    @Test
    public void testBuildSendTxs() {
        AccountInfo account = generateAccountInfo();
        List<String> tos = new ArrayList<>();


        // 创建一笔交易
        String to1 = "okchain1t2cvfv58764q4wdly7qjx5d2z89lewvwq2448n";
        tos.add(to1);
        String memo = "";

        List<Token> amountList1 = new ArrayList<>();
        Token amount1 = new Token();
        amount1.setDenom("okb");
        amount1.setAmount("10.00000000");
        amountList1.add(amount1);

        // 创建第二笔交易
        List<Token> amountList2 = new ArrayList<>();
        String to2 = "okchain1t2cvfv58764q4wdly7qjx5d2z89lewvwq2448n";
        tos.add(to2);
        String memo2 = "";

        Token amount2 = new Token();
        amount2.setDenom("okb");
        amount2.setAmount("2.00000000");
        amountList2.add(amount2);

        List<List<Token>> amountLists = new ArrayList<>();
        amountLists.add(amountList1);
        amountLists.add(amountList2);

        //一次发送多笔交易
        String transacations = BuildTransaction.generateSendTransactions(account, tos, amountLists, memo);
        System.out.println(transacations);

    }
    @Test
    public void testBuildAminoMultiSendTx() throws IOException{
        AccountInfo account = generateAccountInfo();
        List<TransferUnit> transfers = new ArrayList<>();
        String memo = "";

        // 创建一笔交易
        String to1 = "okchain1t2cvfv58764q4wdly7qjx5d2z89lewvwq2448n";
        List<Token> amountList1 = new ArrayList<>();
        Token amount11 = new Token("10.00000000","okb");
        Token amount12 = new Token("5.55500000","btc");
        amountList1.add(amount11);
        amountList1.add(amount12);
        TransferUnit tu1 = new TransferUnit(amountList1,to1);
        transfers.add(tu1);

        // 创建第二笔交易
        List<Token> amountList2 = new ArrayList<>();
        String to2 = "okchain1t2cvfv58764q4wdly7qjx5d2z89lewvwq2448n";

        Token amount21 = new Token("9.999000","bnb");
        Token amount22 = new Token("5.555000","eth");
        Token amount23 = new Token("44.444444","btc");
        amountList2.add(amount21);
        amountList2.add(amount22);
        amountList2.add(amount23);
        TransferUnit tu2 = new TransferUnit(amountList2,to2);
        transfers.add(tu2);
        BuildTransaction.generateAminoMultiSendTransaction(account,transfers,memo);

    }

    private AccountInfo generateAccountInfo() {
        String url = "";
        OKChainClient okc = OKChainClientImpl.getOKChainClient(url);
        AddressInfo addressInfo = okc.createAddressInfo();

        return new AccountInfo(addressInfo, "0", "0");
    }
}