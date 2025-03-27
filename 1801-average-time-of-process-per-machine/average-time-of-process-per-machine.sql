# Write your MySQL query statement below
SELECT machine_id, round(AVG(end_time - start_time),3) AS processing_time
FROM (
    SELECT machine_id, process_id,
           MAX(timestamp) AS end_time,
           MIN(timestamp) AS start_time
    FROM Activity
    GROUP BY machine_id, process_id
) AS temp
GROUP BY machine_id;

