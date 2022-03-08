INSERT INTO interview_event (`tenant_uuid`,
    `uuid`,
    `endTime`,
    `startTime`)
VALUES ('959f75df-efc6-473c-9595-cb8ed707ab3a',
    '25ac63b8-78a1-4418-b693-c903a8a2e752',
    '1815-12-10 16:20:00',
    '1815-12-10 18:20:00');

INSERT INTO `interview_participant` (`uuid`, `interviewRole`, `interviewEvent_uuid`, `person_uuid`) VALUES ('4bb71006-d5bf-4b63-bec3-ae41f4f50f9d', 'Interviewer', '25ac63b8-78a1-4418-b693-c903a8a2e752', '47984be3-0b21-49e4-84ac-6378504709da');
INSERT INTO `interview_participant` (`uuid`, `interviewRole`, `interviewEvent_uuid`, `person_uuid`) VALUES ('acf6ab7f-ca21-420d-84ec-ca3d1d68eb20', 'Candidate', '25ac63b8-78a1-4418-b693-c903a8a2e752', 'f4b5ecd3-d029-4880-a372-af0403e26170');

