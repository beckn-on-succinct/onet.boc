package in.succinct.onet.boc.extensions;

import in.succinct.beckn.Request;
import in.succinct.bpp.core.adaptor.CommerceAdaptor;
import in.succinct.bpp.core.adaptor.api.NetworkApiAdaptor;
import in.succinct.bpp.search.adaptor.SearchAdaptor;

public class BocApiAdaptor extends NetworkApiAdaptor {
    BocApiAdaptor(BecknRegistry networkAdaptor) {
        super(networkAdaptor);
    }


    @Override
    public void search(CommerceAdaptor adaptor, Request request, Request reply) {
        new SearchAdaptor(adaptor).search(request,reply);
    }


    @Override
    public void select(CommerceAdaptor adaptor, Request request, Request reply) {
        new SearchAdaptor(adaptor).select(request,reply);
    }






}
