package com.corkili.learningserver.scorm.cam.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.corkili.learningserver.scorm.cam.model.datatype.AnyURI;
import com.corkili.learningserver.scorm.cam.model.datatype.ID;

/**
 * If an <item> references a <resource>, then the <resource> element shall meet the following requirements:
 * type=webcontent
 * scormType=sco or asset
 * href is required
 */
public class Resource {

    // attributes
    private ID identifier; // M
    private String type; // M
    private String scormType; // M {sco}{asset}
    private String href; // O
    private AnyURI xmlBase; // O

    // elements
    private Metadata metadata; // 0...1
    private List<File> fileList; // 0...1
    private List<Dependency> dependencyList; // 0...n

    public Resource() {
        fileList = new ArrayList<>();
        dependencyList = new ArrayList<>();
    }

    public ID getIdentifier() {
        return identifier;
    }

    public void setIdentifier(ID identifier) {
        this.identifier = identifier;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getScormType() {
        return scormType;
    }

    public void setScormType(String scormType) {
        this.scormType = scormType;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public AnyURI getXmlBase() {
        return xmlBase;
    }

    public void setXmlBase(AnyURI xmlBase) {
        this.xmlBase = xmlBase;
    }

    public Metadata getMetadata() {
        return metadata;
    }

    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }

    public List<File> getFileList() {
        return fileList;
    }

    public void setFileList(List<File> fileList) {
        this.fileList = fileList;
    }

    public List<Dependency> getDependencyList() {
        return dependencyList;
    }

    public void setDependencyList(List<Dependency> dependencyList) {
        this.dependencyList = dependencyList;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("identifier", identifier)
                .append("type", type)
                .append("scormType", scormType)
                .append("href", href)
                .append("xmlBase", xmlBase)
                .append("metadata", metadata)
                .append("fileList", fileList)
                .append("dependencyList", dependencyList)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Resource resource = (Resource) o;

        return new EqualsBuilder()
                .append(identifier, resource.identifier)
                .append(type, resource.type)
                .append(scormType, resource.scormType)
                .append(href, resource.href)
                .append(xmlBase, resource.xmlBase)
                .append(metadata, resource.metadata)
                .append(fileList, resource.fileList)
                .append(dependencyList, resource.dependencyList)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(identifier)
                .append(type)
                .append(scormType)
                .append(href)
                .append(xmlBase)
                .append(metadata)
                .append(fileList)
                .append(dependencyList)
                .toHashCode();
    }
}
