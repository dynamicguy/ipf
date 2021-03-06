/*
 * Copyright 2009 the original author or authors.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *     
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.openehealth.ipf.commons.ihe.xds.core.metadata;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.openehealth.ipf.commons.ihe.xds.core.ExtraMetadataHolder;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;

/**
 * Represents an XDS association.
 * <p>
 * All members of this class are allowed to be <code>null</code>.
 * @author Jens Riemschneider
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Association", propOrder = {
        "entryUuid", "sourceUuid", "targetUuid", "associationType", "label", "docCode",
        "previousVersion", "originalStatus", "newStatus", "associationPropagation", "availabilityStatus",
        "extraMetadata"})
@XmlRootElement(name = "association")
public class Association implements Serializable, ExtraMetadataHolder {

    private static final long serialVersionUID = -4556980177483609469L;

    private String targetUuid;
    private String sourceUuid;
    private AssociationType associationType;
    private AssociationLabel label;
    private String entryUuid;
    private Code docCode;
    private String previousVersion;
    private AvailabilityStatus originalStatus;
    private AvailabilityStatus newStatus;
    private Boolean associationPropagation;
    private AvailabilityStatus availabilityStatus;
    @Getter @Setter private Map<String, ArrayList<String>> extraMetadata;

    /**
     * Constructs an association.
     */
    public Association() {}
    
    /**
     * Constructs an association.
     * @param associationType
     *          the type of the association.
     * @param entryUuid
     *          UUID of the association entry.
     * @param sourceUuid
     *          the UUID of the source object.
     * @param targetUuid
     *          the UUID of the target object.
     */
    public Association(AssociationType associationType, String entryUuid, String sourceUuid, String targetUuid) {
        this.associationType = associationType;
        this.entryUuid = entryUuid;
        this.sourceUuid = sourceUuid;
        this.targetUuid = targetUuid;
    }

    /**
     * @return the UUID of the target object.
     */
    public String getTargetUuid() {
        return targetUuid;
    }

    /**
     * @param targetUuid
     *          the UUID of the target object.
     */
    public void setTargetUuid(String targetUuid) {
        this.targetUuid = targetUuid;
    }

    /**
     * @return the UUID of the source object.
     */
    public String getSourceUuid() {
        return sourceUuid;
    }

    /**
     * @param sourceUuid
     *          the UUID of the source object.
     */
    public void setSourceUuid(String sourceUuid) {
        this.sourceUuid = sourceUuid;
    }

    /**
     * @return the type of this association.
     */
    public AssociationType getAssociationType() {
        return associationType;
    }

    /**
     * @param associationType
     *          the type of this association.
     */
    public void setAssociationType(AssociationType associationType) {
        this.associationType = associationType;
    }

    /**
     * @return the label of the association.
     */
    public AssociationLabel getLabel() {
        return label;
    }

    /**
     * @param label
     *          the label of the association.
     */
    public void setLabel(AssociationLabel label) {
        this.label = label;
    }

    /**
     * @return UUID of this association entry.
     */
    public String getEntryUuid() {
        return entryUuid;
    }

    /**
     * @param entryUuid
     *          UUID of this association entry.
     */
    public void setEntryUuid(String entryUuid) {
        this.entryUuid = entryUuid;
    }

    /**
     * @return code describing the association (e.g. the type of transformation,
     *          reason for replacement).
     */
    public Code getDocCode() {
        return docCode;
    }

    /**
     * @param docCode
     *          code describing the association (e.g. the type of transformation,
     *          reason for replacement).
     */
    public void setDocCode(Code docCode) {
        this.docCode = docCode;
    }

    /**
     *
     * @return previous version slot value
     */
    public String getPreviousVersion() {
        return previousVersion;
    }

    /**
     *
     * @param previousVersion
     *          value of previous version in XDS metadata update association
     */
    public void setPreviousVersion(String previousVersion) {
        this.previousVersion = previousVersion;
    }

    /**
     * @return original status slot value
     */
    public AvailabilityStatus getOriginalStatus() {
        return originalStatus;
    }

    /**
     * @param originalStatus
     *           value of originalStatus in update availabilityStatus
     */
    public void setOriginalStatus(AvailabilityStatus originalStatus) {
        this.originalStatus = originalStatus;
    }

    /**
     * @return new status slot value
     */
    public AvailabilityStatus getNewStatus() {
        return newStatus;
    }

    /**
     * @param newStatus
     *           value of newStatus in update availabilityStatus
     */
    public void setNewStatus(AvailabilityStatus newStatus) {
        this.newStatus = newStatus;
    }

    /**
     * @return associationPropagation annotation value
     */
    public Boolean getAssociationPropagation() {
        return associationPropagation;
    }

    /**
     * @param associationPropagation
     *           value of associationPropagation annotation
     */
    public void setAssociationPropagation(Boolean associationPropagation) {
        this.associationPropagation = associationPropagation;
    }

    /**
     *
     * @return availabilityStatus value in XDS metadata update association
     */
    public AvailabilityStatus getAvailabilityStatus() {
        return availabilityStatus;
    }

    /**
     *
     * @param availabilityStatus
     *           value of availabilityStatus in XDS metadata update association
     */
    public void setAvailabilityStatus(AvailabilityStatus availabilityStatus) {
        this.availabilityStatus = availabilityStatus;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((associationType == null) ? 0 : associationType.hashCode());
        result = prime * result + ((docCode == null) ? 0 : docCode.hashCode());
        result = prime * result + ((entryUuid == null) ? 0 : entryUuid.hashCode());
        result = prime * result + ((label == null) ? 0 : label.hashCode());
        result = prime * result + ((sourceUuid == null) ? 0 : sourceUuid.hashCode());
        result = prime * result + ((targetUuid == null) ? 0 : targetUuid.hashCode());
        result = prime * result + ((previousVersion == null) ? 0 : previousVersion.hashCode());
        result = prime * result + ((originalStatus == null) ? 0 : originalStatus.hashCode());
        result = prime * result + ((newStatus == null) ? 0 : newStatus.hashCode());
        result = prime * result + ((associationPropagation == null) ? 0 : associationPropagation.hashCode());
        result = prime * result + ((availabilityStatus == null) ? 0 : availabilityStatus.hashCode());
        result = prime * result + ((extraMetadata == null) ? 0 : extraMetadata.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Association other = (Association) obj;
        if (associationType == null) {
            if (other.associationType != null)
                return false;
        } else if (!associationType.equals(other.associationType))
            return false;
        if (docCode == null) {
            if (other.docCode != null)
                return false;
        } else if (!docCode.equals(other.docCode))
            return false;
        if (entryUuid == null) {
            if (other.entryUuid != null)
                return false;
        } else if (!entryUuid.equals(other.entryUuid))
            return false;
        if (label == null) {
            if (other.label != null)
                return false;
        } else if (!label.equals(other.label))
            return false;
        if (sourceUuid == null) {
            if (other.sourceUuid != null)
                return false;
        } else if (!sourceUuid.equals(other.sourceUuid))
            return false;
        if (targetUuid == null) {
            if (other.targetUuid != null)
                return false;
        } else if (!targetUuid.equals(other.targetUuid))
            return false;
        if (targetUuid == null) {
            if (other.targetUuid != null)
                return false;
        } else if (!targetUuid.equals(other.targetUuid))
            return false;
        if (previousVersion == null) {
            if (other.previousVersion != null)
                return false;
        } else if (!previousVersion.equals(other.previousVersion))
            return false;
        if (originalStatus == null) {
            if (other.originalStatus != null)
                return false;
        } else if (!originalStatus.equals(other.originalStatus))
            return false;
        if (newStatus == null) {
            if (other.newStatus != null)
                return false;
        } else if (!newStatus.equals(other.newStatus))
            return false;
        if (associationPropagation == null) {
            if (other.associationPropagation != null)
                return false;
        } else if (!associationPropagation.equals(other.associationPropagation))
            return false;
        if (availabilityStatus == null) {
            if (other.availabilityStatus != null)
                return false;
        } else if (!availabilityStatus.equals(other.availabilityStatus))
            return false;
        if (extraMetadata == null) {
            if (other.extraMetadata != null)
                return false;
        } else if (!extraMetadata.equals(other.extraMetadata))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
