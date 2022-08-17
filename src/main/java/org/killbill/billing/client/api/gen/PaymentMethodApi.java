/*
 * Copyright 2010-2014 Ning, Inc.
 * Copyright 2014-2020 Groupon, Inc
 * Copyright 2020-2021 Equinix, Inc
 * Copyright 2014-2021 The Billing Project, LLC
 *
 * The Billing Project licenses this file to you under the Apache License, version 2.0
 * (the "License"); you may not use this file except in compliance with the
 * License.  You may obtain a copy of the License at:
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */


package org.killbill.billing.client.api.gen;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Objects;

import org.killbill.billing.client.model.gen.AuditLog;
import org.killbill.billing.client.model.gen.CustomField;
import org.killbill.billing.client.model.gen.PaymentMethod;
import java.util.UUID;
import org.killbill.billing.client.model.CustomFields;
import java.util.List;
import java.util.Map;
import org.killbill.billing.util.api.AuditLevel;
import org.killbill.billing.client.model.AuditLogs;
import org.killbill.billing.client.model.PaymentMethods;

import org.killbill.billing.client.Converter;
import org.killbill.billing.client.KillBillClientException;
import org.killbill.billing.client.KillBillHttpClient;
import org.killbill.billing.client.RequestOptions;
import org.killbill.billing.client.RequestOptions.RequestOptionsBuilder;


/**
 *           DO NOT EDIT !!!
 *
 * This code has been generated by the Kill Bill swagger generator.
 *  @See https://github.com/killbill/killbill-swagger-coden
 */
public class PaymentMethodApi {

    private final KillBillHttpClient httpClient;

    public PaymentMethodApi() {
        this(new KillBillHttpClient());
    }

    public PaymentMethodApi(final KillBillHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    private <K, V> void addToMapValues(final Map<K, Collection<V>> map, final K key, final Collection<V> values) {
        if (map.containsKey(key)) {
            map.get(key).addAll(values);
        } else {
            map.put(key, values);
        }
    }

    public static <T> T checkNotNull(final T reference, final Object errorMessage) {
        if (reference == null) {
            throw new NullPointerException(String.valueOf(errorMessage));
        }
        return reference;
    }

    public CustomFields createPaymentMethodCustomFields(final UUID paymentMethodId, final CustomFields body, final RequestOptions inputOptions) throws KillBillClientException {
        checkNotNull(paymentMethodId, "Missing the required parameter 'paymentMethodId' when calling createPaymentMethodCustomFields");
        checkNotNull(body, "Missing the required parameter 'body' when calling createPaymentMethodCustomFields");

        final String uri = "/1.0/kb/paymentMethods/{paymentMethodId}/customFields"
          .replaceAll("\\{" + "paymentMethodId" + "\\}", paymentMethodId.toString());


        final RequestOptionsBuilder inputOptionsBuilder = inputOptions.extend();
        final Boolean followLocation = Objects.requireNonNullElse(inputOptions.getFollowLocation(), Boolean.TRUE);
        inputOptionsBuilder.withFollowLocation(followLocation);
        inputOptionsBuilder.withHeader(KillBillHttpClient.HTTP_HEADER_ACCEPT, "application/json");
        inputOptionsBuilder.withHeader(KillBillHttpClient.HTTP_HEADER_CONTENT_TYPE, "application/json");
        final RequestOptions requestOptions = inputOptionsBuilder.build();

        return httpClient.doPost(uri, body, CustomFields.class, requestOptions);
    }

    public void deletePaymentMethod(final UUID paymentMethodId, final Map<String, String> pluginProperty, final RequestOptions inputOptions) throws KillBillClientException {
        deletePaymentMethod(paymentMethodId, Boolean.valueOf(false), Boolean.valueOf(false), pluginProperty, inputOptions);
    }


    public void deletePaymentMethod(final UUID paymentMethodId, final Boolean deleteDefaultPmWithAutoPayOff, final Boolean forceDefaultPmDeletion, final Map<String, String> pluginProperty, final RequestOptions inputOptions) throws KillBillClientException {
        checkNotNull(paymentMethodId, "Missing the required parameter 'paymentMethodId' when calling deletePaymentMethod");

        final String uri = "/1.0/kb/paymentMethods/{paymentMethodId}"
          .replaceAll("\\{" + "paymentMethodId" + "\\}", paymentMethodId.toString());

        final Map<String, Collection<String>> queryParams = new HashMap<>(inputOptions.getQueryParams());
        if (deleteDefaultPmWithAutoPayOff != null) {
            addToMapValues(queryParams, "deleteDefaultPmWithAutoPayOff", List.of(String.valueOf(deleteDefaultPmWithAutoPayOff)));
        }
        if (forceDefaultPmDeletion != null) {
            addToMapValues(queryParams, "forceDefaultPmDeletion", List.of(String.valueOf(forceDefaultPmDeletion)));
        }
        if (pluginProperty != null) {
            addToMapValues(queryParams, "pluginProperty", Converter.convertPluginPropertyMap(pluginProperty));
        }

        final RequestOptionsBuilder inputOptionsBuilder = inputOptions.extend();
        inputOptionsBuilder.withQueryParams(queryParams);
        inputOptionsBuilder.withHeader(KillBillHttpClient.HTTP_HEADER_ACCEPT, "application/json");
        final RequestOptions requestOptions = inputOptionsBuilder.build();

        httpClient.doDelete(uri, requestOptions);
    }


    public void deletePaymentMethodCustomFields(final UUID paymentMethodId, final List<UUID> customField, final RequestOptions inputOptions) throws KillBillClientException {
        checkNotNull(paymentMethodId, "Missing the required parameter 'paymentMethodId' when calling deletePaymentMethodCustomFields");

        final String uri = "/1.0/kb/paymentMethods/{paymentMethodId}/customFields"
          .replaceAll("\\{" + "paymentMethodId" + "\\}", paymentMethodId.toString());

        final Map<String, Collection<String>> queryParams = new HashMap<>(inputOptions.getQueryParams());
        if (customField != null) {
            addToMapValues(queryParams, "customField", Converter.convertUUIDListToStringList(customField));
        }

        final RequestOptionsBuilder inputOptionsBuilder = inputOptions.extend();
        inputOptionsBuilder.withQueryParams(queryParams);
        inputOptionsBuilder.withHeader(KillBillHttpClient.HTTP_HEADER_ACCEPT, "application/json");
        inputOptionsBuilder.withHeader(KillBillHttpClient.HTTP_HEADER_CONTENT_TYPE, "application/json");
        final RequestOptions requestOptions = inputOptionsBuilder.build();

        httpClient.doDelete(uri, requestOptions);
    }

    public PaymentMethod getPaymentMethod(final UUID paymentMethodId, final Map<String, String> pluginProperty, final RequestOptions inputOptions) throws KillBillClientException {
        return getPaymentMethod(paymentMethodId, Boolean.valueOf(false), Boolean.valueOf(false), pluginProperty, AuditLevel.NONE, inputOptions);
    }

    public PaymentMethod getPaymentMethod(final UUID paymentMethodId, final Boolean includedDeleted, final Boolean withPluginInfo, final Map<String, String> pluginProperty, final AuditLevel audit, final RequestOptions inputOptions) throws KillBillClientException {
        checkNotNull(paymentMethodId, "Missing the required parameter 'paymentMethodId' when calling getPaymentMethod");

        final String uri = "/1.0/kb/paymentMethods/{paymentMethodId}"
          .replaceAll("\\{" + "paymentMethodId" + "\\}", paymentMethodId.toString());

        final Map<String, Collection<String>> queryParams = new HashMap<>(inputOptions.getQueryParams());
        if (includedDeleted != null) {
            addToMapValues(queryParams, "includedDeleted", List.of(String.valueOf(includedDeleted)));
        }
        if (withPluginInfo != null) {
            addToMapValues(queryParams, "withPluginInfo", List.of(String.valueOf(withPluginInfo)));
        }
        if (pluginProperty != null) {
            addToMapValues(queryParams, "pluginProperty", Converter.convertPluginPropertyMap(pluginProperty));
        }
        if (audit != null) {
            addToMapValues(queryParams, "audit", List.of(String.valueOf(audit)));
        }

        final RequestOptionsBuilder inputOptionsBuilder = inputOptions.extend();
        inputOptionsBuilder.withQueryParams(queryParams);
        inputOptionsBuilder.withHeader(KillBillHttpClient.HTTP_HEADER_ACCEPT, "application/json");
        final RequestOptions requestOptions = inputOptionsBuilder.build();

        return httpClient.doGet(uri, PaymentMethod.class, requestOptions);
    }

    public AuditLogs getPaymentMethodAuditLogsWithHistory(final UUID paymentMethodId, final RequestOptions inputOptions) throws KillBillClientException {
        checkNotNull(paymentMethodId, "Missing the required parameter 'paymentMethodId' when calling getPaymentMethodAuditLogsWithHistory");

        final String uri = "/1.0/kb/paymentMethods/{paymentMethodId}/auditLogsWithHistory"
          .replaceAll("\\{" + "paymentMethodId" + "\\}", paymentMethodId.toString());


        final RequestOptionsBuilder inputOptionsBuilder = inputOptions.extend();
        inputOptionsBuilder.withHeader(KillBillHttpClient.HTTP_HEADER_ACCEPT, "application/json");
        final RequestOptions requestOptions = inputOptionsBuilder.build();

        return httpClient.doGet(uri, AuditLogs.class, requestOptions);
    }

    public PaymentMethod getPaymentMethodByKey(final String externalKey, final Map<String, String> pluginProperty, final RequestOptions inputOptions) throws KillBillClientException {
        return getPaymentMethodByKey(externalKey, Boolean.valueOf(false), Boolean.valueOf(false), pluginProperty, AuditLevel.NONE, inputOptions);
    }

    public PaymentMethod getPaymentMethodByKey(final String externalKey, final Boolean includedDeleted, final Boolean withPluginInfo, final Map<String, String> pluginProperty, final AuditLevel audit, final RequestOptions inputOptions) throws KillBillClientException {
        checkNotNull(externalKey, "Missing the required parameter 'externalKey' when calling getPaymentMethodByKey");

        final String uri = "/1.0/kb/paymentMethods";

        final Map<String, Collection<String>> queryParams = new HashMap<>(inputOptions.getQueryParams());
        if (externalKey != null) {
            addToMapValues(queryParams, "externalKey", List.of(String.valueOf(externalKey)));
        }
        if (includedDeleted != null) {
            addToMapValues(queryParams, "includedDeleted", List.of(String.valueOf(includedDeleted)));
        }
        if (withPluginInfo != null) {
            addToMapValues(queryParams, "withPluginInfo", List.of(String.valueOf(withPluginInfo)));
        }
        if (pluginProperty != null) {
            addToMapValues(queryParams, "pluginProperty", Converter.convertPluginPropertyMap(pluginProperty));
        }
        if (audit != null) {
            addToMapValues(queryParams, "audit", List.of(String.valueOf(audit)));
        }

        final RequestOptionsBuilder inputOptionsBuilder = inputOptions.extend();
        inputOptionsBuilder.withQueryParams(queryParams);
        inputOptionsBuilder.withHeader(KillBillHttpClient.HTTP_HEADER_ACCEPT, "application/json");
        final RequestOptions requestOptions = inputOptionsBuilder.build();

        return httpClient.doGet(uri, PaymentMethod.class, requestOptions);
    }

    public CustomFields getPaymentMethodCustomFields(final UUID paymentMethodId, final RequestOptions inputOptions) throws KillBillClientException {
        return getPaymentMethodCustomFields(paymentMethodId, AuditLevel.NONE, inputOptions);
    }

    public CustomFields getPaymentMethodCustomFields(final UUID paymentMethodId, final AuditLevel audit, final RequestOptions inputOptions) throws KillBillClientException {
        checkNotNull(paymentMethodId, "Missing the required parameter 'paymentMethodId' when calling getPaymentMethodCustomFields");

        final String uri = "/1.0/kb/paymentMethods/{paymentMethodId}/customFields"
          .replaceAll("\\{" + "paymentMethodId" + "\\}", paymentMethodId.toString());

        final Map<String, Collection<String>> queryParams = new HashMap<>(inputOptions.getQueryParams());
        if (audit != null) {
            addToMapValues(queryParams, "audit", List.of(String.valueOf(audit)));
        }

        final RequestOptionsBuilder inputOptionsBuilder = inputOptions.extend();
        inputOptionsBuilder.withQueryParams(queryParams);
        inputOptionsBuilder.withHeader(KillBillHttpClient.HTTP_HEADER_ACCEPT, "application/json");
        final RequestOptions requestOptions = inputOptionsBuilder.build();

        return httpClient.doGet(uri, CustomFields.class, requestOptions);
    }

    public PaymentMethods getPaymentMethods(final String pluginName, final Map<String, String> pluginProperty, final RequestOptions inputOptions) throws KillBillClientException {
        return getPaymentMethods(Long.valueOf(0), Long.valueOf(100), pluginName, Boolean.valueOf(false), pluginProperty, AuditLevel.NONE, inputOptions);
    }

    public PaymentMethods getPaymentMethods(final Long offset, final Long limit, final String pluginName, final Boolean withPluginInfo, final Map<String, String> pluginProperty, final AuditLevel audit, final RequestOptions inputOptions) throws KillBillClientException {

        final String uri = "/1.0/kb/paymentMethods/pagination";

        final Map<String, Collection<String>> queryParams = new HashMap<>(inputOptions.getQueryParams());
        if (offset != null) {
            addToMapValues(queryParams, "offset", List.of(String.valueOf(offset)));
        }
        if (limit != null) {
            addToMapValues(queryParams, "limit", List.of(String.valueOf(limit)));
        }
        if (pluginName != null) {
            addToMapValues(queryParams, "pluginName", List.of(String.valueOf(pluginName)));
        }
        if (withPluginInfo != null) {
            addToMapValues(queryParams, "withPluginInfo", List.of(String.valueOf(withPluginInfo)));
        }
        if (pluginProperty != null) {
            addToMapValues(queryParams, "pluginProperty", Converter.convertPluginPropertyMap(pluginProperty));
        }
        if (audit != null) {
            addToMapValues(queryParams, "audit", List.of(String.valueOf(audit)));
        }

        final RequestOptionsBuilder inputOptionsBuilder = inputOptions.extend();
        inputOptionsBuilder.withQueryParams(queryParams);
        inputOptionsBuilder.withHeader(KillBillHttpClient.HTTP_HEADER_ACCEPT, "application/json");
        final RequestOptions requestOptions = inputOptionsBuilder.build();

        return httpClient.doGet(uri, PaymentMethods.class, requestOptions);
    }

    public void modifyPaymentMethodCustomFields(final UUID paymentMethodId, final CustomFields body, final RequestOptions inputOptions) throws KillBillClientException {
        checkNotNull(paymentMethodId, "Missing the required parameter 'paymentMethodId' when calling modifyPaymentMethodCustomFields");
        checkNotNull(body, "Missing the required parameter 'body' when calling modifyPaymentMethodCustomFields");

        final String uri = "/1.0/kb/paymentMethods/{paymentMethodId}/customFields"
          .replaceAll("\\{" + "paymentMethodId" + "\\}", paymentMethodId.toString());


        final RequestOptionsBuilder inputOptionsBuilder = inputOptions.extend();
        inputOptionsBuilder.withHeader(KillBillHttpClient.HTTP_HEADER_ACCEPT, "application/json");
        inputOptionsBuilder.withHeader(KillBillHttpClient.HTTP_HEADER_CONTENT_TYPE, "application/json");
        final RequestOptions requestOptions = inputOptionsBuilder.build();

        httpClient.doPut(uri, body, requestOptions);
    }

    public PaymentMethods searchPaymentMethods(final String searchKey, final String pluginName, final Map<String, String> pluginProperty, final RequestOptions inputOptions) throws KillBillClientException {
        return searchPaymentMethods(searchKey, Long.valueOf(0), Long.valueOf(100), pluginName, Boolean.valueOf(false), pluginProperty, AuditLevel.NONE, inputOptions);
    }

    public PaymentMethods searchPaymentMethods(final String searchKey, final Long offset, final Long limit, final String pluginName, final Boolean withPluginInfo, final Map<String, String> pluginProperty, final AuditLevel audit, final RequestOptions inputOptions) throws KillBillClientException {
        checkNotNull(searchKey, "Missing the required parameter 'searchKey' when calling searchPaymentMethods");

        final String uri = "/1.0/kb/paymentMethods/search/{searchKey}"
          .replaceAll("\\{" + "searchKey" + "\\}", searchKey.toString());

        final Map<String, Collection<String>> queryParams = new HashMap<>(inputOptions.getQueryParams());
        if (offset != null) {
            addToMapValues(queryParams, "offset", List.of(String.valueOf(offset)));
        }
        if (limit != null) {
            addToMapValues(queryParams, "limit", List.of(String.valueOf(limit)));
        }
        if (pluginName != null) {
            addToMapValues(queryParams, "pluginName", List.of(String.valueOf(pluginName)));
        }
        if (withPluginInfo != null) {
            addToMapValues(queryParams, "withPluginInfo", List.of(String.valueOf(withPluginInfo)));
        }
        if (pluginProperty != null) {
            addToMapValues(queryParams, "pluginProperty", Converter.convertPluginPropertyMap(pluginProperty));
        }
        if (audit != null) {
            addToMapValues(queryParams, "audit", List.of(String.valueOf(audit)));
        }

        final RequestOptionsBuilder inputOptionsBuilder = inputOptions.extend();
        inputOptionsBuilder.withQueryParams(queryParams);
        inputOptionsBuilder.withHeader(KillBillHttpClient.HTTP_HEADER_ACCEPT, "application/json");
        final RequestOptions requestOptions = inputOptionsBuilder.build();

        return httpClient.doGet(uri, PaymentMethods.class, requestOptions);
    }

}
