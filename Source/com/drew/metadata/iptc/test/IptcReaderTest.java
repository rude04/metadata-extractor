/*
 * Copyright 2002-2011 Drew Noakes
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 *
 * More information about this project is available at:
 *
 *    http://drewnoakes.com/code/exif/
 *    http://code.google.com/p/metadata-extractor/
 */
package com.drew.metadata.iptc.test;

import com.drew.imaging.jpeg.JpegSegmentReader;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.MetadataReader;
import com.drew.metadata.iptc.IptcDirectory;
import com.drew.metadata.iptc.IptcReader;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;

/**
 * @author Drew Noakes http://drewnoakes.com
 */
public class IptcReaderTest
{
    @Test
    public void testDescription_City() throws Exception
    {
        File iptcFile = new File("Source/com/drew/metadata/iptc/test/withIptc.jpg");
        MetadataReader reader = new IptcReader(new JpegSegmentReader(iptcFile).readSegment(JpegSegmentReader.SEGMENT_APPD));
        Metadata metadata = new Metadata();
        reader.extract(metadata);
        Assert.assertTrue(metadata.containsDirectory(IptcDirectory.class));
        Directory directory = metadata.getDirectory(IptcDirectory.class);
        Assert.assertEquals("City", directory.getDescription(IptcDirectory.TAG_CITY));
    }

    @Test
    public void testDescription_Caption() throws Exception
    {
        File iptcFile = new File("Source/com/drew/metadata/iptc/test/withIptc.jpg");
        MetadataReader reader = new IptcReader(new JpegSegmentReader(iptcFile).readSegment(JpegSegmentReader.SEGMENT_APPD));
        Metadata metadata = new Metadata();
        reader.extract(metadata);
        Assert.assertTrue(metadata.containsDirectory(IptcDirectory.class));
        Directory directory = metadata.getDirectory(IptcDirectory.class);
        Assert.assertEquals("Caption", directory.getDescription(IptcDirectory.TAG_CAPTION));
    }

    @Test
    public void testDescription_Category() throws Exception
    {
        File iptcFile = new File("Source/com/drew/metadata/iptc/test/withIptc.jpg");
        MetadataReader reader = new IptcReader(new JpegSegmentReader(iptcFile).readSegment(JpegSegmentReader.SEGMENT_APPD));
        Metadata metadata = new Metadata();
        reader.extract(metadata);
        Assert.assertTrue(metadata.containsDirectory(IptcDirectory.class));
        Directory directory = metadata.getDirectory(IptcDirectory.class);
        Assert.assertEquals("Supl. Category2 Supl. Category1 Cat", directory.getDescription(IptcDirectory.TAG_CATEGORY));
    }

    // TODO Wrap more tests around the Iptc reader
}
