package de.weichand.inspire.opensearch.dataset.impl;

import de.weichand.inspire.opensearch.dataset.iface.ISimpleDatasetConfiguration;

/**
 * @author Juergen Weichand
 */
public class Dtk500Impl implements ISimpleDatasetConfiguration {

    public String getOpenSearchDescriptionDocument() {
        return "http://www.weichand.de/inspire/dls/dtk500.opensearch.xml";
    }

    public String getDatasetFeed() {
        return "http://www.weichand.de/inspire/dls/dtk500.DEBY_dfe019ad-817c-3aa8-a653-5371134bf3d9.xml";
    }

    public String getDataset(int epsg) {
        String url = "http://www.weichand.de/inspire/data/dtk500_epsg$EPSG$.tiff";
        return url.replace("$EPSG$", String.valueOf(epsg));
    }
    
}
