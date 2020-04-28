package examples.orm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import examples.entity.OrganizationModel;

public interface OrganizationMapper {
	public OrganizationModel getOrganization(@Param("organization_id") String organizationId);
	public List<OrganizationModel> findAll();
	public void entryOrganization(OrganizationModel organizationModel);

}
