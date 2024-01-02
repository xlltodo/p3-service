package com.p3.service.packages.application.assembler;

import com.p3.service.packages.application.command.QualityControlSheetServiceCommand;
import com.p3.service.packages.application.result.QualityControlSheetServiceResult;
import com.p3.service.packages.domain.model.entity.QualityControlSheetServiceItem;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class QualityControlSheetServiceItemAssembler {

    public static QualityControlSheetServiceItem toEntity(String sheetId, QualityControlSheetServiceCommand command) {
        return new QualityControlSheetServiceItem(
                null,
                sheetId,
                command.getServiceType(),
                command.getServiceName(),
                command.getFee(),
                command.getActivated(),
                LocalDateTime.now());
    }

    public static List<QualityControlSheetServiceItem> toEntities(String sheetId, List<QualityControlSheetServiceCommand> commands) {
        return commands.stream().map(command -> QualityControlSheetServiceItemAssembler.toEntity(sheetId, command)).collect(Collectors.toList());
    }

    public static QualityControlSheetServiceResult toResult(QualityControlSheetServiceItem serviceItem) {
        return serviceItem.mapWith((id, sheetId, serviceType, serviceName, fee, activated, creationTime) ->
                new QualityControlSheetServiceResult()
                        .setServiceType(serviceType)
                        .setServiceName(serviceName)
                        .setFee(fee)
                        .setActivated(activated)
                        .setCreationTime(creationTime)
        );
    }

    public static List<QualityControlSheetServiceResult> toResults(List<QualityControlSheetServiceItem> serviceItems) {
        return serviceItems.stream().map(QualityControlSheetServiceItemAssembler::toResult).collect(Collectors.toList());
    }
}
