package com.basejava.webapp;

import com.basejava.webapp.model.Resume;

import java.util.*;

public class MainCollections {
    private static final String FULLNAME_1 = "fullName1";
    private static final Resume RESUME_1 = new Resume(FULLNAME_1);

    private static final String FULLNAME_2 = "fullName2";
    private static final Resume RESUME_2 = new Resume(FULLNAME_2);

    private static final String FULLNAME_3 = "fullName3";
    private static final Resume RESUME_3 = new Resume(FULLNAME_3);

    public static void main(String[] args) {
        Collection<Resume> collection = new ArrayList<>();
        collection.add(RESUME_1);
        collection.add(RESUME_2);
        collection.add(RESUME_3);

        for (Resume r : collection) {
            System.out.println(r);
            if (Objects.equals(r.getUuid(), FULLNAME_1)) {
//                collection.remove(r);
            }
        }

        Iterator<Resume> iterator = collection.iterator();
        while (iterator.hasNext()) {
            Resume r = iterator.next();
            System.out.println(r);
            if (Objects.equals(r.getUuid(), FULLNAME_1)) {
                iterator.remove();
            }
        }
        System.out.println(collection);


        Map<String, Resume> map = new HashMap<>();
        map.put(FULLNAME_1, RESUME_1);
        map.put(FULLNAME_2, RESUME_2);
        map.put(FULLNAME_3, RESUME_3);

        // Bad!
        for (String uuid : map.keySet()) {
            System.out.println(map.get(uuid));
        }

        for (Map.Entry<String, Resume> entry : map.entrySet()) {
            System.out.println(entry.getValue());
        }
        List<Resume> resumes = Arrays.asList(RESUME_1, RESUME_2, RESUME_3);
        resumes.remove(1);
        System.out.println(resumes);
    }
}
