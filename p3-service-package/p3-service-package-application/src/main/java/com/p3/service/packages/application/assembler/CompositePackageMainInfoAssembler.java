package com.p3.service.packages.application.assembler;

import com.p3.service.packages.application.command.CompositePackageCommand;
import com.p3.service.packages.domain.model.entity.CompositePackageAssociation;
import com.p3.service.packages.domain.model.entity.CompositePackageMainInfo;
import com.p3.service.packages.domain.model.entity.CompositePackageSpatialAttribute;
import com.p3.service.packages.domain.model.factory.CompositePackageAssociationFactory;
import com.p3.service.packages.domain.model.factory.CompositePackageMainInfoFactory;
import com.p3.service.packages.domain.model.factory.CompositePackageSpatialAttributeFactory;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CompositePackageMainInfoAssembler {

    public static CompositePackageMainInfo toEntity(String compositeCode, CompositePackageCommand command) {

        return CompositePackageMainInfoFactory.create(
                null,
                compositeCode,
                command.getCompositeMethod(),
                Optional.ofNullable(command.getPackageCodes()).map(List::size).orElse(0),
                command.getPackagingType(),
                command.getShippingMethod(),
                command.getPrimaryGoodsType(),
                command.getSecondaryGoodsType(),
                null,
                CompositePackageMainInfoAssembler.toCompositePackageSpatialAttributeDomainEntities(compositeCode, command),
                CompositePackageMainInfoAssembler.toCompositePackageAssociationDomainEntities(compositeCode, command.getPackageCodes())
        );
    }

    public static List<CompositePackageSpatialAttribute> toCompositePackageSpatialAttributeDomainEntities(String compositeCode, CompositePackageCommand command) {

        CompositePackageSpatialAttribute spatialAttribute = CompositePackageSpatialAttributeFactory.create(
                null,
                compositeCode,
                command.getLength(),
                command.getWidth(),
                command.getHeight(),
                command.getVolume(),
                command.getWeight(),
                LocalDateTime.now()
        );
        return List.of(spatialAttribute);
    }

    public static List<CompositePackageAssociation> toCompositePackageAssociationDomainEntities(String compositeCode, List<String> packageCodes) {

        return packageCodes.stream().map(packageCode -> CompositePackageAssociationFactory.create(
                null,
                compositeCode,
                packageCode
        )).collect(Collectors.toList());
    }
}
