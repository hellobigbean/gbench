/*
 * Copyright 2012 Nagai Masato
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import java.lang.management.CompilationMXBean
import java.lang.management.GarbageCollectorMXBean
import java.lang.management.ManagementFactory

/* $if version >= 2.0.0 $ */
@groovy.transform.TypeChecked
/* $endif$ */
/* $if version >= 1.8.0 $ */
@groovy.transform.PackageScope
/* $endif$ */
class Benchmarker {
    
    private static long measurementTimeInterval() {
        1L * 1000 * 1000 * 1000 // 1 sec
    }
    
    private static long computeExecutionTimes(Closure task) {
        long times = 0
        long ti = measurementTimeInterval()
        long st = BenchmarkMeasure.time()
        while (true) {
            task()
            times++
            if (BenchmarkMeasure.time() - st >= ti) {
                break
            }
        }
        times
    }
    
    static Map run(label, Closure task) {
        long execTimes = computeExecutionTimes(task)
		BenchmarkLogger.trace("Warming up \"$label\"...")
        BenchmarkWarmUp.run(task, execTimes)
		BenchmarkLogger.trace("Measuring \"$label\"...")
        Map result = BenchmarkMeasure.run(task, execTimes)
        return [
            label: label,
            time: new BenchmarkTime(
                      real: ((long) result.executionTime) / execTimes,
                      cpu: ((long) result.cpuTime) / execTimes,
                      system: ((long) result.systemTime) / execTimes,
                      user: ((long) result.userTime) / execTimes,
                  )
        ]
    } 

}