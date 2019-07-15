/*
 * Copyright 2014-2018 Groupon, Inc
 * Copyright 2014-2018 The Billing Project, LLC
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


import org.killbill.billing.client.model.gen.AuditLog;
import org.killbill.billing.client.model.gen.BlockingState;
import org.killbill.billing.client.model.gen.BulkSubscriptionsBundle;
import org.killbill.billing.client.model.gen.Bundle;
import org.killbill.billing.client.model.gen.CustomField;
import org.joda.time.LocalDate;
import org.killbill.billing.client.model.gen.Subscription;
import org.killbill.billing.client.model.gen.Tag;
import java.util.UUID;
import org.killbill.billing.client.model.BlockingStates;
import java.util.List;
import java.util.Map;
import org.killbill.billing.entitlement.api.Entitlement.EntitlementActionPolicy;
import org.killbill.billing.catalog.api.BillingActionPolicy;
import org.killbill.billing.client.model.CustomFields;
import org.killbill.billing.client.model.Subscriptions;
import org.killbill.billing.client.model.Bundles;
import org.killbill.billing.client.model.BulkSubscriptionsBundles;
import org.killbill.billing.util.api.AuditLevel;
import org.killbill.billing.client.model.AuditLogs;
import org.killbill.billing.client.model.Tags;

import com.google.common.collect.Multimap;
import com.google.common.base.Preconditions;
import com.google.common.base.MoreObjects;
import com.google.common.collect.LinkedListMultimap;

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
public class SubscriptionApi {

    private final KillBillHttpClient httpClient;

    public SubscriptionApi() {
        this(new KillBillHttpClient());
    }

    public SubscriptionApi(final KillBillHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public BlockingStates addSubscriptionBlockingState(final UUID subscriptionId, final BlockingState body, final LocalDate requestedDate, final Map<String, String> pluginProperty, final RequestOptions inputOptions) throws KillBillClientException {
        Preconditions.checkNotNull(subscriptionId, "Missing the required parameter 'subscriptionId' when calling addSubscriptionBlockingState");
        Preconditions.checkNotNull(body, "Missing the required parameter 'body' when calling addSubscriptionBlockingState");

        final String uri = "/1.0/kb/subscriptions/{subscriptionId}/block"
          .replaceAll("\\{" + "subscriptionId" + "\\}", subscriptionId.toString());

        final Multimap<String, String> queryParams = LinkedListMultimap.create(inputOptions.getQueryParams());
        if (requestedDate != null) {
            queryParams.put("requestedDate", String.valueOf(requestedDate));
        }
        if (pluginProperty != null) {
            queryParams.putAll("pluginProperty", Converter.convertPluginPropertyMap(pluginProperty));
        }

        final RequestOptionsBuilder inputOptionsBuilder = inputOptions.extend();
        final Boolean followLocation = MoreObjects.firstNonNull(inputOptions.getFollowLocation(), Boolean.TRUE);
        inputOptionsBuilder.withFollowLocation(followLocation);
        inputOptionsBuilder.withQueryParams(queryParams);
        inputOptionsBuilder.withHeader(KillBillHttpClient.HTTP_HEADER_CONTENT_TYPE, "application/json");
        final RequestOptions requestOptions = inputOptionsBuilder.build();

        return httpClient.doPost(uri, body, BlockingStates.class, requestOptions);
    }

    public void cancelSubscriptionPlan(final UUID subscriptionId, final LocalDate requestedDate, final EntitlementActionPolicy entitlementPolicy, final BillingActionPolicy billingPolicy, final Map<String, String> pluginProperty, final RequestOptions inputOptions) throws KillBillClientException {
        cancelSubscriptionPlan(subscriptionId, requestedDate, Boolean.valueOf(false), Long.valueOf(5), entitlementPolicy, billingPolicy, Boolean.valueOf(false), pluginProperty, inputOptions);
    }


    public void cancelSubscriptionPlan(final UUID subscriptionId, final LocalDate requestedDate, final Boolean callCompletion, final Long callTimeoutSec, final EntitlementActionPolicy entitlementPolicy, final BillingActionPolicy billingPolicy, final Boolean useRequestedDateForBilling, final Map<String, String> pluginProperty, final RequestOptions inputOptions) throws KillBillClientException {
        Preconditions.checkNotNull(subscriptionId, "Missing the required parameter 'subscriptionId' when calling cancelSubscriptionPlan");

        final String uri = "/1.0/kb/subscriptions/{subscriptionId}"
          .replaceAll("\\{" + "subscriptionId" + "\\}", subscriptionId.toString());

        final Multimap<String, String> queryParams = LinkedListMultimap.create(inputOptions.getQueryParams());
        if (requestedDate != null) {
            queryParams.put("requestedDate", String.valueOf(requestedDate));
        }
        if (callCompletion != null) {
            queryParams.put("callCompletion", String.valueOf(callCompletion));
        }
        if (callTimeoutSec != null) {
            queryParams.put("callTimeoutSec", String.valueOf(callTimeoutSec));
        }
        if (entitlementPolicy != null) {
            queryParams.put("entitlementPolicy", String.valueOf(entitlementPolicy));
        }
        if (billingPolicy != null) {
            queryParams.put("billingPolicy", String.valueOf(billingPolicy));
        }
        if (useRequestedDateForBilling != null) {
            queryParams.put("useRequestedDateForBilling", String.valueOf(useRequestedDateForBilling));
        }
        if (pluginProperty != null) {
            queryParams.putAll("pluginProperty", Converter.convertPluginPropertyMap(pluginProperty));
        }

        final RequestOptionsBuilder inputOptionsBuilder = inputOptions.extend();
        inputOptionsBuilder.withQueryParams(queryParams);
        inputOptionsBuilder.withHeader(KillBillHttpClient.HTTP_HEADER_ACCEPT, "application/json");
        final RequestOptions requestOptions = inputOptionsBuilder.build();

        httpClient.doDelete(uri, requestOptions);
    }

    public void changeSubscriptionPlan(final UUID subscriptionId, final Subscription body, final LocalDate requestedDate, final BillingActionPolicy billingPolicy, final Map<String, String> pluginProperty, final RequestOptions inputOptions) throws KillBillClientException {
        changeSubscriptionPlan(subscriptionId, body, requestedDate, Boolean.valueOf(false), Long.valueOf(3), billingPolicy, pluginProperty, inputOptions);
    }

    public void changeSubscriptionPlan(final UUID subscriptionId, final Subscription body, final LocalDate requestedDate, final Boolean callCompletion, final Long callTimeoutSec, final BillingActionPolicy billingPolicy, final Map<String, String> pluginProperty, final RequestOptions inputOptions) throws KillBillClientException {
        Preconditions.checkNotNull(subscriptionId, "Missing the required parameter 'subscriptionId' when calling changeSubscriptionPlan");
        Preconditions.checkNotNull(body, "Missing the required parameter 'body' when calling changeSubscriptionPlan");

        final String uri = "/1.0/kb/subscriptions/{subscriptionId}"
          .replaceAll("\\{" + "subscriptionId" + "\\}", subscriptionId.toString());

        final Multimap<String, String> queryParams = LinkedListMultimap.create(inputOptions.getQueryParams());
        if (requestedDate != null) {
            queryParams.put("requestedDate", String.valueOf(requestedDate));
        }
        if (callCompletion != null) {
            queryParams.put("callCompletion", String.valueOf(callCompletion));
        }
        if (callTimeoutSec != null) {
            queryParams.put("callTimeoutSec", String.valueOf(callTimeoutSec));
        }
        if (billingPolicy != null) {
            queryParams.put("billingPolicy", String.valueOf(billingPolicy));
        }
        if (pluginProperty != null) {
            queryParams.putAll("pluginProperty", Converter.convertPluginPropertyMap(pluginProperty));
        }

        final RequestOptionsBuilder inputOptionsBuilder = inputOptions.extend();
        inputOptionsBuilder.withQueryParams(queryParams);
        inputOptionsBuilder.withHeader(KillBillHttpClient.HTTP_HEADER_ACCEPT, "application/json");
        inputOptionsBuilder.withHeader(KillBillHttpClient.HTTP_HEADER_CONTENT_TYPE, "application/json");
        final RequestOptions requestOptions = inputOptionsBuilder.build();

        httpClient.doPut(uri, body, requestOptions);
    }

    public Subscription createSubscription(final Subscription body, final LocalDate entitlementDate, final LocalDate billingDate, final Map<String, String> pluginProperty, final RequestOptions inputOptions) throws KillBillClientException {
        return createSubscription(body, entitlementDate, billingDate, Boolean.valueOf(true), Boolean.valueOf(false), Boolean.valueOf(false), Long.valueOf(3), pluginProperty, inputOptions);
    }

    public Subscription createSubscription(final Subscription body, final LocalDate entitlementDate, final LocalDate billingDate, final Boolean renameKeyIfExistsAndUnused, final Boolean migrated, final Boolean callCompletion, final Long callTimeoutSec, final Map<String, String> pluginProperty, final RequestOptions inputOptions) throws KillBillClientException {
        Preconditions.checkNotNull(body, "Missing the required parameter 'body' when calling createSubscription");

        final String uri = "/1.0/kb/subscriptions";

        final Multimap<String, String> queryParams = LinkedListMultimap.create(inputOptions.getQueryParams());
        if (entitlementDate != null) {
            queryParams.put("entitlementDate", String.valueOf(entitlementDate));
        }
        if (billingDate != null) {
            queryParams.put("billingDate", String.valueOf(billingDate));
        }
        if (renameKeyIfExistsAndUnused != null) {
            queryParams.put("renameKeyIfExistsAndUnused", String.valueOf(renameKeyIfExistsAndUnused));
        }
        if (migrated != null) {
            queryParams.put("migrated", String.valueOf(migrated));
        }
        if (callCompletion != null) {
            queryParams.put("callCompletion", String.valueOf(callCompletion));
        }
        if (callTimeoutSec != null) {
            queryParams.put("callTimeoutSec", String.valueOf(callTimeoutSec));
        }
        if (pluginProperty != null) {
            queryParams.putAll("pluginProperty", Converter.convertPluginPropertyMap(pluginProperty));
        }

        final RequestOptionsBuilder inputOptionsBuilder = inputOptions.extend();
        final Boolean followLocation = MoreObjects.firstNonNull(inputOptions.getFollowLocation(), Boolean.TRUE);
        inputOptionsBuilder.withFollowLocation(followLocation);
        inputOptionsBuilder.withQueryParams(queryParams);
        inputOptionsBuilder.withHeader(KillBillHttpClient.HTTP_HEADER_ACCEPT, "application/json");
        inputOptionsBuilder.withHeader(KillBillHttpClient.HTTP_HEADER_CONTENT_TYPE, "application/json");
        final RequestOptions requestOptions = inputOptionsBuilder.build();

        return httpClient.doPost(uri, body, Subscription.class, requestOptions);
    }

    public void createSubscriptionCustomFields(final UUID subscriptionId, final CustomFields body, final RequestOptions inputOptions) throws KillBillClientException {
        Preconditions.checkNotNull(subscriptionId, "Missing the required parameter 'subscriptionId' when calling createSubscriptionCustomFields");
        Preconditions.checkNotNull(body, "Missing the required parameter 'body' when calling createSubscriptionCustomFields");

        final String uri = "/1.0/kb/subscriptions/{subscriptionId}/customFields"
          .replaceAll("\\{" + "subscriptionId" + "\\}", subscriptionId.toString());


        final RequestOptionsBuilder inputOptionsBuilder = inputOptions.extend();
        final Boolean followLocation = MoreObjects.firstNonNull(inputOptions.getFollowLocation(), Boolean.TRUE);
        inputOptionsBuilder.withFollowLocation(followLocation);
        inputOptionsBuilder.withHeader(KillBillHttpClient.HTTP_HEADER_ACCEPT, "application/json");
        inputOptionsBuilder.withHeader(KillBillHttpClient.HTTP_HEADER_CONTENT_TYPE, "application/json");
        final RequestOptions requestOptions = inputOptionsBuilder.build();

        httpClient.doPost(uri, body, requestOptions);
    }

    public void createSubscriptionTags(final UUID subscriptionId, final List<UUID> body, final RequestOptions inputOptions) throws KillBillClientException {
        Preconditions.checkNotNull(subscriptionId, "Missing the required parameter 'subscriptionId' when calling createSubscriptionTags");
        Preconditions.checkNotNull(body, "Missing the required parameter 'body' when calling createSubscriptionTags");

        final String uri = "/1.0/kb/subscriptions/{subscriptionId}/tags"
          .replaceAll("\\{" + "subscriptionId" + "\\}", subscriptionId.toString());


        final RequestOptionsBuilder inputOptionsBuilder = inputOptions.extend();
        final Boolean followLocation = MoreObjects.firstNonNull(inputOptions.getFollowLocation(), Boolean.TRUE);
        inputOptionsBuilder.withFollowLocation(followLocation);
        inputOptionsBuilder.withHeader(KillBillHttpClient.HTTP_HEADER_ACCEPT, "application/json");
        inputOptionsBuilder.withHeader(KillBillHttpClient.HTTP_HEADER_CONTENT_TYPE, "application/json");
        final RequestOptions requestOptions = inputOptionsBuilder.build();

        httpClient.doPost(uri, body, requestOptions);
    }

    public Bundle createSubscriptionWithAddOns(final Subscriptions body, final LocalDate entitlementDate, final LocalDate billingDate, final Map<String, String> pluginProperty, final RequestOptions inputOptions) throws KillBillClientException {
        return createSubscriptionWithAddOns(body, entitlementDate, billingDate, Boolean.valueOf(false), Boolean.valueOf(true), Boolean.valueOf(false), Long.valueOf(3), pluginProperty, inputOptions);
    }

    public Bundle createSubscriptionWithAddOns(final Subscriptions body, final LocalDate entitlementDate, final LocalDate billingDate, final Boolean migrated, final Boolean renameKeyIfExistsAndUnused, final Boolean callCompletion, final Long callTimeoutSec, final Map<String, String> pluginProperty, final RequestOptions inputOptions) throws KillBillClientException {
        Preconditions.checkNotNull(body, "Missing the required parameter 'body' when calling createSubscriptionWithAddOns");

        final String uri = "/1.0/kb/subscriptions/createSubscriptionWithAddOns";

        final Multimap<String, String> queryParams = LinkedListMultimap.create(inputOptions.getQueryParams());
        if (entitlementDate != null) {
            queryParams.put("entitlementDate", String.valueOf(entitlementDate));
        }
        if (billingDate != null) {
            queryParams.put("billingDate", String.valueOf(billingDate));
        }
        if (migrated != null) {
            queryParams.put("migrated", String.valueOf(migrated));
        }
        if (renameKeyIfExistsAndUnused != null) {
            queryParams.put("renameKeyIfExistsAndUnused", String.valueOf(renameKeyIfExistsAndUnused));
        }
        if (callCompletion != null) {
            queryParams.put("callCompletion", String.valueOf(callCompletion));
        }
        if (callTimeoutSec != null) {
            queryParams.put("callTimeoutSec", String.valueOf(callTimeoutSec));
        }
        if (pluginProperty != null) {
            queryParams.putAll("pluginProperty", Converter.convertPluginPropertyMap(pluginProperty));
        }

        final RequestOptionsBuilder inputOptionsBuilder = inputOptions.extend();
        final Boolean followLocation = MoreObjects.firstNonNull(inputOptions.getFollowLocation(), Boolean.TRUE);
        inputOptionsBuilder.withFollowLocation(followLocation);
        inputOptionsBuilder.withQueryParams(queryParams);
        inputOptionsBuilder.withHeader(KillBillHttpClient.HTTP_HEADER_ACCEPT, "application/json");
        inputOptionsBuilder.withHeader(KillBillHttpClient.HTTP_HEADER_CONTENT_TYPE, "application/json");
        final RequestOptions requestOptions = inputOptionsBuilder.build();

        return httpClient.doPost(uri, body, Bundle.class, requestOptions);
    }

    public Bundles createSubscriptionsWithAddOns(final BulkSubscriptionsBundles body, final LocalDate entitlementDate, final LocalDate billingDate, final Map<String, String> pluginProperty, final RequestOptions inputOptions) throws KillBillClientException {
        return createSubscriptionsWithAddOns(body, entitlementDate, billingDate, Boolean.valueOf(true), Boolean.valueOf(false), Boolean.valueOf(false), Long.valueOf(3), pluginProperty, inputOptions);
    }

    public Bundles createSubscriptionsWithAddOns(final BulkSubscriptionsBundles body, final LocalDate entitlementDate, final LocalDate billingDate, final Boolean renameKeyIfExistsAndUnused, final Boolean migrated, final Boolean callCompletion, final Long callTimeoutSec, final Map<String, String> pluginProperty, final RequestOptions inputOptions) throws KillBillClientException {
        Preconditions.checkNotNull(body, "Missing the required parameter 'body' when calling createSubscriptionsWithAddOns");

        final String uri = "/1.0/kb/subscriptions/createSubscriptionsWithAddOns";

        final Multimap<String, String> queryParams = LinkedListMultimap.create(inputOptions.getQueryParams());
        if (entitlementDate != null) {
            queryParams.put("entitlementDate", String.valueOf(entitlementDate));
        }
        if (billingDate != null) {
            queryParams.put("billingDate", String.valueOf(billingDate));
        }
        if (renameKeyIfExistsAndUnused != null) {
            queryParams.put("renameKeyIfExistsAndUnused", String.valueOf(renameKeyIfExistsAndUnused));
        }
        if (migrated != null) {
            queryParams.put("migrated", String.valueOf(migrated));
        }
        if (callCompletion != null) {
            queryParams.put("callCompletion", String.valueOf(callCompletion));
        }
        if (callTimeoutSec != null) {
            queryParams.put("callTimeoutSec", String.valueOf(callTimeoutSec));
        }
        if (pluginProperty != null) {
            queryParams.putAll("pluginProperty", Converter.convertPluginPropertyMap(pluginProperty));
        }

        final RequestOptionsBuilder inputOptionsBuilder = inputOptions.extend();
        final Boolean followLocation = MoreObjects.firstNonNull(inputOptions.getFollowLocation(), Boolean.TRUE);
        inputOptionsBuilder.withFollowLocation(followLocation);
        inputOptionsBuilder.withQueryParams(queryParams);
        inputOptionsBuilder.withHeader(KillBillHttpClient.HTTP_HEADER_ACCEPT, "application/json");
        inputOptionsBuilder.withHeader(KillBillHttpClient.HTTP_HEADER_CONTENT_TYPE, "application/json");
        final RequestOptions requestOptions = inputOptionsBuilder.build();

        return httpClient.doPost(uri, body, Bundles.class, requestOptions);
    }


    public void deleteSubscriptionCustomFields(final UUID subscriptionId, final List<UUID> customField, final RequestOptions inputOptions) throws KillBillClientException {
        Preconditions.checkNotNull(subscriptionId, "Missing the required parameter 'subscriptionId' when calling deleteSubscriptionCustomFields");

        final String uri = "/1.0/kb/subscriptions/{subscriptionId}/customFields"
          .replaceAll("\\{" + "subscriptionId" + "\\}", subscriptionId.toString());

        final Multimap<String, String> queryParams = LinkedListMultimap.create(inputOptions.getQueryParams());
        if (customField != null) {
            queryParams.putAll("customField", Converter.convertUUIDListToStringList(customField));
        }

        final RequestOptionsBuilder inputOptionsBuilder = inputOptions.extend();
        inputOptionsBuilder.withQueryParams(queryParams);
        inputOptionsBuilder.withHeader(KillBillHttpClient.HTTP_HEADER_ACCEPT, "application/json");
        inputOptionsBuilder.withHeader(KillBillHttpClient.HTTP_HEADER_CONTENT_TYPE, "application/json");
        final RequestOptions requestOptions = inputOptionsBuilder.build();

        httpClient.doDelete(uri, requestOptions);
    }


    public void deleteSubscriptionTags(final UUID subscriptionId, final List<UUID> tagDef, final RequestOptions inputOptions) throws KillBillClientException {
        Preconditions.checkNotNull(subscriptionId, "Missing the required parameter 'subscriptionId' when calling deleteSubscriptionTags");

        final String uri = "/1.0/kb/subscriptions/{subscriptionId}/tags"
          .replaceAll("\\{" + "subscriptionId" + "\\}", subscriptionId.toString());

        final Multimap<String, String> queryParams = LinkedListMultimap.create(inputOptions.getQueryParams());
        if (tagDef != null) {
            queryParams.putAll("tagDef", Converter.convertUUIDListToStringList(tagDef));
        }

        final RequestOptionsBuilder inputOptionsBuilder = inputOptions.extend();
        inputOptionsBuilder.withQueryParams(queryParams);
        inputOptionsBuilder.withHeader(KillBillHttpClient.HTTP_HEADER_ACCEPT, "application/json");
        inputOptionsBuilder.withHeader(KillBillHttpClient.HTTP_HEADER_CONTENT_TYPE, "application/json");
        final RequestOptions requestOptions = inputOptionsBuilder.build();

        httpClient.doDelete(uri, requestOptions);
    }

    public Subscription getSubscription(final UUID subscriptionId, final RequestOptions inputOptions) throws KillBillClientException {
        return getSubscription(subscriptionId, AuditLevel.NONE, inputOptions);
    }

    public Subscription getSubscription(final UUID subscriptionId, final AuditLevel audit, final RequestOptions inputOptions) throws KillBillClientException {
        Preconditions.checkNotNull(subscriptionId, "Missing the required parameter 'subscriptionId' when calling getSubscription");

        final String uri = "/1.0/kb/subscriptions/{subscriptionId}"
          .replaceAll("\\{" + "subscriptionId" + "\\}", subscriptionId.toString());

        final Multimap<String, String> queryParams = LinkedListMultimap.create(inputOptions.getQueryParams());
        if (audit != null) {
            queryParams.put("audit", String.valueOf(audit));
        }

        final RequestOptionsBuilder inputOptionsBuilder = inputOptions.extend();
        inputOptionsBuilder.withQueryParams(queryParams);
        inputOptionsBuilder.withHeader(KillBillHttpClient.HTTP_HEADER_ACCEPT, "application/json");
        final RequestOptions requestOptions = inputOptionsBuilder.build();

        return httpClient.doGet(uri, Subscription.class, requestOptions);
    }

    public AuditLogs getSubscriptionAuditLogsWithHistory(final UUID subscriptionId, final RequestOptions inputOptions) throws KillBillClientException {
        Preconditions.checkNotNull(subscriptionId, "Missing the required parameter 'subscriptionId' when calling getSubscriptionAuditLogsWithHistory");

        final String uri = "/1.0/kb/subscriptions/{subscriptionId}/auditLogsWithHistory"
          .replaceAll("\\{" + "subscriptionId" + "\\}", subscriptionId.toString());


        final RequestOptionsBuilder inputOptionsBuilder = inputOptions.extend();
        inputOptionsBuilder.withHeader(KillBillHttpClient.HTTP_HEADER_ACCEPT, "application/json");
        final RequestOptions requestOptions = inputOptionsBuilder.build();

        return httpClient.doGet(uri, AuditLogs.class, requestOptions);
    }

    public Subscription getSubscriptionByKey(final String externalKey, final RequestOptions inputOptions) throws KillBillClientException {
        return getSubscriptionByKey(externalKey, AuditLevel.NONE, inputOptions);
    }

    public Subscription getSubscriptionByKey(final String externalKey, final AuditLevel audit, final RequestOptions inputOptions) throws KillBillClientException {
        Preconditions.checkNotNull(externalKey, "Missing the required parameter 'externalKey' when calling getSubscriptionByKey");

        final String uri = "/1.0/kb/subscriptions";

        final Multimap<String, String> queryParams = LinkedListMultimap.create(inputOptions.getQueryParams());
        if (externalKey != null) {
            queryParams.put("externalKey", String.valueOf(externalKey));
        }
        if (audit != null) {
            queryParams.put("audit", String.valueOf(audit));
        }

        final RequestOptionsBuilder inputOptionsBuilder = inputOptions.extend();
        inputOptionsBuilder.withQueryParams(queryParams);
        inputOptionsBuilder.withHeader(KillBillHttpClient.HTTP_HEADER_ACCEPT, "application/json");
        final RequestOptions requestOptions = inputOptionsBuilder.build();

        return httpClient.doGet(uri, Subscription.class, requestOptions);
    }

    public CustomFields getSubscriptionCustomFields(final UUID subscriptionId, final RequestOptions inputOptions) throws KillBillClientException {
        return getSubscriptionCustomFields(subscriptionId, AuditLevel.NONE, inputOptions);
    }

    public CustomFields getSubscriptionCustomFields(final UUID subscriptionId, final AuditLevel audit, final RequestOptions inputOptions) throws KillBillClientException {
        Preconditions.checkNotNull(subscriptionId, "Missing the required parameter 'subscriptionId' when calling getSubscriptionCustomFields");

        final String uri = "/1.0/kb/subscriptions/{subscriptionId}/customFields"
          .replaceAll("\\{" + "subscriptionId" + "\\}", subscriptionId.toString());

        final Multimap<String, String> queryParams = LinkedListMultimap.create(inputOptions.getQueryParams());
        if (audit != null) {
            queryParams.put("audit", String.valueOf(audit));
        }

        final RequestOptionsBuilder inputOptionsBuilder = inputOptions.extend();
        inputOptionsBuilder.withQueryParams(queryParams);
        inputOptionsBuilder.withHeader(KillBillHttpClient.HTTP_HEADER_ACCEPT, "application/json");
        final RequestOptions requestOptions = inputOptionsBuilder.build();

        return httpClient.doGet(uri, CustomFields.class, requestOptions);
    }

    public AuditLogs getSubscriptionEventAuditLogsWithHistory(final UUID eventId, final RequestOptions inputOptions) throws KillBillClientException {
        Preconditions.checkNotNull(eventId, "Missing the required parameter 'eventId' when calling getSubscriptionEventAuditLogsWithHistory");

        final String uri = "/1.0/kb/subscriptions/events/{eventId}/auditLogsWithHistory"
          .replaceAll("\\{" + "eventId" + "\\}", eventId.toString());


        final RequestOptionsBuilder inputOptionsBuilder = inputOptions.extend();
        inputOptionsBuilder.withHeader(KillBillHttpClient.HTTP_HEADER_ACCEPT, "application/json");
        final RequestOptions requestOptions = inputOptionsBuilder.build();

        return httpClient.doGet(uri, AuditLogs.class, requestOptions);
    }

    public Tags getSubscriptionTags(final UUID subscriptionId, final RequestOptions inputOptions) throws KillBillClientException {
        return getSubscriptionTags(subscriptionId, Boolean.valueOf(false), AuditLevel.NONE, inputOptions);
    }

    public Tags getSubscriptionTags(final UUID subscriptionId, final Boolean includedDeleted, final AuditLevel audit, final RequestOptions inputOptions) throws KillBillClientException {
        Preconditions.checkNotNull(subscriptionId, "Missing the required parameter 'subscriptionId' when calling getSubscriptionTags");

        final String uri = "/1.0/kb/subscriptions/{subscriptionId}/tags"
          .replaceAll("\\{" + "subscriptionId" + "\\}", subscriptionId.toString());

        final Multimap<String, String> queryParams = LinkedListMultimap.create(inputOptions.getQueryParams());
        if (includedDeleted != null) {
            queryParams.put("includedDeleted", String.valueOf(includedDeleted));
        }
        if (audit != null) {
            queryParams.put("audit", String.valueOf(audit));
        }

        final RequestOptionsBuilder inputOptionsBuilder = inputOptions.extend();
        inputOptionsBuilder.withQueryParams(queryParams);
        inputOptionsBuilder.withHeader(KillBillHttpClient.HTTP_HEADER_ACCEPT, "application/json");
        final RequestOptions requestOptions = inputOptionsBuilder.build();

        return httpClient.doGet(uri, Tags.class, requestOptions);
    }

    public void modifySubscriptionCustomFields(final UUID subscriptionId, final CustomFields body, final RequestOptions inputOptions) throws KillBillClientException {
        Preconditions.checkNotNull(subscriptionId, "Missing the required parameter 'subscriptionId' when calling modifySubscriptionCustomFields");
        Preconditions.checkNotNull(body, "Missing the required parameter 'body' when calling modifySubscriptionCustomFields");

        final String uri = "/1.0/kb/subscriptions/{subscriptionId}/customFields"
          .replaceAll("\\{" + "subscriptionId" + "\\}", subscriptionId.toString());


        final RequestOptionsBuilder inputOptionsBuilder = inputOptions.extend();
        inputOptionsBuilder.withHeader(KillBillHttpClient.HTTP_HEADER_ACCEPT, "application/json");
        inputOptionsBuilder.withHeader(KillBillHttpClient.HTTP_HEADER_CONTENT_TYPE, "application/json");
        final RequestOptions requestOptions = inputOptionsBuilder.build();

        httpClient.doPut(uri, body, requestOptions);
    }

    public void uncancelSubscriptionPlan(final UUID subscriptionId, final Map<String, String> pluginProperty, final RequestOptions inputOptions) throws KillBillClientException {
        Preconditions.checkNotNull(subscriptionId, "Missing the required parameter 'subscriptionId' when calling uncancelSubscriptionPlan");

        final String uri = "/1.0/kb/subscriptions/{subscriptionId}/uncancel"
          .replaceAll("\\{" + "subscriptionId" + "\\}", subscriptionId.toString());

        final Multimap<String, String> queryParams = LinkedListMultimap.create(inputOptions.getQueryParams());
        if (pluginProperty != null) {
            queryParams.putAll("pluginProperty", Converter.convertPluginPropertyMap(pluginProperty));
        }

        final RequestOptionsBuilder inputOptionsBuilder = inputOptions.extend();
        inputOptionsBuilder.withQueryParams(queryParams);
        inputOptionsBuilder.withHeader(KillBillHttpClient.HTTP_HEADER_ACCEPT, "application/json");
        final RequestOptions requestOptions = inputOptionsBuilder.build();

        httpClient.doPut(uri, null, requestOptions);
    }

    public void undoChangeSubscriptionPlan(final UUID subscriptionId, final Map<String, String> pluginProperty, final RequestOptions inputOptions) throws KillBillClientException {
        Preconditions.checkNotNull(subscriptionId, "Missing the required parameter 'subscriptionId' when calling undoChangeSubscriptionPlan");

        final String uri = "/1.0/kb/subscriptions/{subscriptionId}/undoChangePlan"
          .replaceAll("\\{" + "subscriptionId" + "\\}", subscriptionId.toString());

        final Multimap<String, String> queryParams = LinkedListMultimap.create(inputOptions.getQueryParams());
        if (pluginProperty != null) {
            queryParams.putAll("pluginProperty", Converter.convertPluginPropertyMap(pluginProperty));
        }

        final RequestOptionsBuilder inputOptionsBuilder = inputOptions.extend();
        inputOptionsBuilder.withQueryParams(queryParams);
        inputOptionsBuilder.withHeader(KillBillHttpClient.HTTP_HEADER_ACCEPT, "application/json");
        final RequestOptions requestOptions = inputOptionsBuilder.build();

        httpClient.doPut(uri, null, requestOptions);
    }

    public void updateSubscriptionBCD(final UUID subscriptionId, final Subscription body, final LocalDate effectiveFromDate, final RequestOptions inputOptions) throws KillBillClientException {
        updateSubscriptionBCD(subscriptionId, body, effectiveFromDate, Boolean.valueOf(false), inputOptions);
    }

    public void updateSubscriptionBCD(final UUID subscriptionId, final Subscription body, final LocalDate effectiveFromDate, final Boolean forceNewBcdWithPastEffectiveDate, final RequestOptions inputOptions) throws KillBillClientException {
        Preconditions.checkNotNull(subscriptionId, "Missing the required parameter 'subscriptionId' when calling updateSubscriptionBCD");
        Preconditions.checkNotNull(body, "Missing the required parameter 'body' when calling updateSubscriptionBCD");

        final String uri = "/1.0/kb/subscriptions/{subscriptionId}/bcd"
          .replaceAll("\\{" + "subscriptionId" + "\\}", subscriptionId.toString());

        final Multimap<String, String> queryParams = LinkedListMultimap.create(inputOptions.getQueryParams());
        if (effectiveFromDate != null) {
            queryParams.put("effectiveFromDate", String.valueOf(effectiveFromDate));
        }
        if (forceNewBcdWithPastEffectiveDate != null) {
            queryParams.put("forceNewBcdWithPastEffectiveDate", String.valueOf(forceNewBcdWithPastEffectiveDate));
        }

        final RequestOptionsBuilder inputOptionsBuilder = inputOptions.extend();
        inputOptionsBuilder.withQueryParams(queryParams);
        inputOptionsBuilder.withHeader(KillBillHttpClient.HTTP_HEADER_ACCEPT, "application/json");
        inputOptionsBuilder.withHeader(KillBillHttpClient.HTTP_HEADER_CONTENT_TYPE, "application/json");
        final RequestOptions requestOptions = inputOptionsBuilder.build();

        httpClient.doPut(uri, body, requestOptions);
    }

}
