/*
 * Copyright (c) 2008-2013, Hazelcast, Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.hazelcast.mapreduce;

import com.hazelcast.core.CompletableFuture;

public interface SubmittableJob<EntryKey, ValueIn> {

    SubmittableJob<EntryKey, ValueIn> onKeys(Iterable<EntryKey> keys);

    SubmittableJob<EntryKey, ValueIn> onKeys(EntryKey... keys);

    SubmittableJob<EntryKey, ValueIn> keyPredicate(KeyPredicate<EntryKey> predicate);

    CompletableFuture<ValueIn> submit();

    <ValueOut> CompletableFuture<ValueOut> submit(Collator<ValueIn, ValueOut> collator);

}
