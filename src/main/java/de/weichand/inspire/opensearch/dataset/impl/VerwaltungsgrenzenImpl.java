package de.weichand.inspire.opensearch.dataset.impl;

import de.weichand.inspire.opensearch.dataset.iface.ISimpleDatasetConfiguration;

/**
 * @author Juergen Weichand
 */
public class VerwaltungsgrenzenImpl implements ISimpleDatasetConfiguration {

    public String getOpenSearchDescriptionDocument() {
        return "http://www.weichand.de/inspire/dls/verwaltungsgrenzen.opensearch.xml";
    }

    public String getDatasetFeed() {
        return "http://www.weichand.de/inspire/dls/verwaltungsgrenzen.DEBY_125cce16-7ae1-3cf0-96e2-05a4453f3cb1.xml";
    }

    public String getDataset(int epsg) {
        String url = "http://www.weichand.de/inspire/dls/verwaltungsgrenzen.DEBY_125cce16-7ae1-3cf0-96e2-05a4453f3cb1.epsg$EPSG$.xml";
        return url.replace("$EPSG$", String.valueOf(epsg));
    }
    
}
