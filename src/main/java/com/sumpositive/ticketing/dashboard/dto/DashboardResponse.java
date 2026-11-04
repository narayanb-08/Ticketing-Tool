
package com.sumpositive.ticketing.dashboard.dto;

public class DashboardResponse {

    private long totalTickets;
    private long openTickets;
    private long inProgressTickets;
    private long closedTickets;
    private long totalUsers;

    public DashboardResponse() {
    }

    public DashboardResponse(long totalTickets,
                           long openTickets,
                           long inProgressTickets,
                           long closedTickets,
                           long totalUsers) {

        this.totalTickets = totalTickets;
        this.openTickets = openTickets;
        this.inProgressTickets = inProgressTickets;
        this.closedTickets = closedTickets;
        this.totalUsers = totalUsers;
    }

    public long getTotalTickets() {
        return totalTickets;
    }

    public void setTotalTickets(long totalTickets) {
        this.totalTickets = totalTickets;
    }

    public long getOpenTickets() {
        return openTickets;
    }

    public void setOpenTickets(long openTickets) {
        this.openTickets = openTickets;
    }

    public long getInProgressTickets() {
        return inProgressTickets;
    }

    public void setInProgressTickets(long inProgressTickets) {
        this.inProgressTickets = inProgressTickets;
    }

    public long getClosedTickets() {
        return closedTickets;
    }

    public void setClosedTickets(long closedTickets) {
        this.closedTickets = closedTickets;
    }

    public long getTotalUsers() {
        return totalUsers;
    }

    public void setTotalUsers(long totalUsers) {
        this.totalUsers = totalUsers;
    }
}
