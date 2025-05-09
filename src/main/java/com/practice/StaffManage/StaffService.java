package com.practice.StaffManage;

import com.practice.StaffManage.Staff;   // Saxan!
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class StaffService {

    private final Map<Long, Staff> staffMap = new HashMap<>();
    private Long nextId = 1L;

    public List<Staff> getAllStaff() {
        return new ArrayList<>(staffMap.values());
    }

    public Staff getStaffById(Long id) {
        return staffMap.get(id);
    }

    public Staff createStaff(Staff staff) {
        staff.setId(nextId++);
        staffMap.put(staff.getId(), staff);
        return staff;
    }

    public Staff updateStaff(Long id, Staff staff) {
        if (staffMap.containsKey(id)) {
            staff.setId(id);
            staffMap.put(id, staff);
            return staff;
        }
        return null;
    }

    public boolean deleteStaff(Long id) {
        return staffMap.remove(id) != null;
    }
}
