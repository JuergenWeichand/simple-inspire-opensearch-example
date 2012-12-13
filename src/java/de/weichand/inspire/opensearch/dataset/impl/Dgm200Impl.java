package de.weichand.inspire.opensearch.dataset.impl;

import de.weichand.inspire.opensearch.dataset.iface.ISimpleDatasetConfiguration;

/**
 * @author Juergen Weichand
 */
public class Dgm200Impl implements ISimpleDatasetConfiguration {

    public String getOpenSearchDescriptionDocument() {
        return "http://www.weichand.de/inspire/dls/dgm200.opensearch.xml";
    }

    public String getDatasetFeed() {
        return "http://www.weichand.de/inspire/dls/dgm200.DEBY_1d4ab890-27e7-3ebb-95ba-2d2ab8071871.xml";
    }

    public String getDataset(int epsg) {
        String url = "http://www.weichand.de/inspire/data/dgm200_epsg$EPSG$.tiff";
        return url.replace("$EPSG$", String.valueOf(epsg));
    }
    
}
